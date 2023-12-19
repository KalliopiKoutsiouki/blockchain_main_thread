package com.warehouse.repository;

import com.warehouse.model.BlockDto;
import com.warehouse.model.ProductBlock;
import com.warehouse.model.ProductDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlockRepository extends CrudRepository<ProductBlock, Long> {

    ProductBlock save(ProductBlock entity);

    List<ProductBlock> findAll();

    ProductBlock findTopByOrderByIdDesc();
    @Query("select p from ProductBlock p where p.blockJson like %?1 order by p.id desc" )
    List<ProductBlock> findProductContainingCode(String productCode);

    ProductBlock findFirstByOrderByIdDesc();


}
