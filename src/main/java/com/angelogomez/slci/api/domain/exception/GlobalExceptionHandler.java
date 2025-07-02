package com.angelogomez.slci.api.domain.exception;

import com.angelogomez.slci.api.interfaces.dto.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponse> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Custom Bad Resquest", ex.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        log.error("Error de validación: ", ex);
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .min(Comparator.comparingInt(error -> FieldPriority.getFieldPriority(error.getField())))
                .map(fieldError -> fieldError.getDefaultMessage())
                .orElse("Error desconocido");

        return buildResponse(HttpStatus.BAD_REQUEST, "VALIDATION_FAILED", errorMessage, request);
    }

    private enum FieldPriority {
        marca(1), stock(2), apeMaterno(3), dni(4),
        telefonoCelular(5), direccion(6), email(7),
        centroTrabajo(8), cargo(9), fechaNacimiento(10);

        private static final Map<String, Integer> PRIORITY_MAP = Map.of(
                "marca", 1, "stock", 2, "apeMaterno", 3,
                "dni", 4, "telefonoCelular", 5, "direccion", 6,
                "email", 7, "centroTrabajo", 8, "cargo", 9,
                "fechaNacimiento", 10
        );

        private final int priority;

        FieldPriority(int priority) {
            this.priority = priority;
        }

        public static int getFieldPriority(String fieldName) {
            return PRIORITY_MAP.getOrDefault(fieldName, Integer.MAX_VALUE);
        }
    }

    private ResponseEntity<ApiErrorResponse> buildResponse(HttpStatus status, String errorHeader, String message, HttpServletRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                new Date(),
                status.value(),
                errorHeader,
                message,
                request.getRequestURI()
        );
        return ResponseEntity.status(status.value()).body(errorResponse);
    }

}
