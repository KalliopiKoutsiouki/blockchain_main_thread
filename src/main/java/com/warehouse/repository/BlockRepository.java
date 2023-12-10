package com.warehouse.repository;

import com.warehouse.model.ProductBlock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlockRepository extends CrudRepository<ProductBlock, Long> {

    ProductBlock save(ProductBlock entity);

    List<ProductBlock> findAll();

    ProductBlock findTopByOrderByIdDesc();
    List<ProductBlock> findProductBlockByBlockJson(String blockJson);


}
