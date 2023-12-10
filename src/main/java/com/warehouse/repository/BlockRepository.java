package com.warehouse.repository;

import com.warehouse.model.ProductBlock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlockRepository extends CrudRepository<ProductBlock, Long> {

    ProductBlock save(ProductBlock entity);

    List<ProductBlock> findAll();

    List<ProductBlock> findProductBlockByBlockJson(String blockJson);
}
