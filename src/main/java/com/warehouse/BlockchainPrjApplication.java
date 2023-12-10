package com.warehouse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.warehouse.model.BlockDto;
import com.warehouse.model.Product;
import com.warehouse.model.ProductBlock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class BlockchainPrjApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlockchainPrjApplication.class, args);
        int prefix = 4;
        Product productA;
        productA = new Product(0, "1111", "firstProduct", 3, "this is the first product", "skincare");
        String productData = new Gson().toJson(productA);
        BlockDto genesisDto = new BlockDto("0", productData );
        genesisDto.mineBlock(prefix);
        String blockA = new Gson().toJson(genesisDto);
        ProductBlock firstBlock = new ProductBlock();
        firstBlock.setBlockJson(blockA);
        // convert to ProductBlock genesis
        // repository add genesis;


        Product productB;
        productB = new Product(1, "2222", "secondProduct", 15, "this is the second product", "sports");
        // repository find last
        // decypher to get : previous hash
        // repository findAll
        // search to see if product code already exists, keep that id
        // if exists -> productB.setPreviousID = X
        String productBData = new Gson().toJson(productB);
        BlockDto nextBlockDto = new BlockDto("getPreviousBlockHash", productBData);
        nextBlockDto.mineBlock(prefix);
        String blockB = new Gson().toJson(nextBlockDto);
        ProductBlock nextBlock = new ProductBlock();
        nextBlock.setBlockJson(blockB);
        // repository add nextblock
    }

}
