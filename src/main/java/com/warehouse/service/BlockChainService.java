package com.warehouse.service;

import com.warehouse.model.ProductBlock;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlockChainService {

    ProductBlock save(ProductBlock productBlock);

    List<ProductBlock> getAll(ProductBlock productBlock);

    ProductBlock getById(String id);

    ProductBlock findLastBlock();
}
