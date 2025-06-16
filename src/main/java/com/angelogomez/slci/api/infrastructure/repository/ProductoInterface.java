package com.angelogomez.slci.api.infrastructure.repository;

import com.angelogomez.slci.api.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoInterface extends JpaRepository<ProductoEntity, Integer> {
}
