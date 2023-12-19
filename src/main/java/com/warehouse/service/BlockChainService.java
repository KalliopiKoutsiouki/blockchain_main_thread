package com.warehouse.service;

import com.warehouse.model.BlockDto;
import com.warehouse.model.ProductDto;
import com.warehouse.model.ProductBlock;

import java.util.List;

public interface BlockChainService {

    void save(ProductDto product);

    List<ProductDto> getAll();

    ProductBlock getById(String id);

    ProductBlock findLastRecord();
}
