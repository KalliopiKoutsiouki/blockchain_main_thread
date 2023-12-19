package com.warehouse;

import com.google.gson.Gson;
import com.warehouse.model.BlockDto;
import com.warehouse.model.ProductDto;
import com.warehouse.model.ProductBlock;
import com.warehouse.repository.BlockRepository;
import com.warehouse.service.BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainPrjApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlockchainPrjApplication.class, args);

//        ProductDto productA;
//        productA = new ProductDto(0, "1111", "firstProduct", 3, "this is the first product", "skincare");
//



        // repository add genesis;


//        ProductDto productB;
//        productB = new ProductDto(1, "2222", "secondProduct", 15, "this is the second product", "sports");
//        // repository findAll
//        // search to see if product code already exists, keep that id
//        // if exists -> productB.setPreviousID = X
//        String productBData = new Gson().toJson(productB);
//        BlockDto nextBlockDto = new BlockDto("getPreviousBlockHash", productBData);
////        nextBlockDto.mineBlock(prefix);
//        String blockB = new Gson().toJson(nextBlockDto);
//        ProductBlock nextBlock = new ProductBlock(blockB);
//        // repository add nextblock
    }

}
