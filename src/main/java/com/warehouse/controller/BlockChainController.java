package com.warehouse.controller;

import com.warehouse.model.ProductBlock;
import com.warehouse.model.ProductDto;
import com.warehouse.service.BlockChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blockchain")
//@Api(tags = "BlockChainController", description = "Operations related to blockchain")
public class BlockChainController {

    @Autowired
    BlockChainService blockChainService;

    @PostMapping("/save")
//    @ApiOperation("Save a product to the blockchain")
    public void saveProduct(@RequestBody ProductDto product) {
        blockChainService.save(product);
    }

    @GetMapping("/getAll")
    public List<ProductDto> getAllProducts() {
        return blockChainService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ProductBlock getProductById(@PathVariable String id) {
        return blockChainService.getById(id);
    }

    @GetMapping("/findLastRecord")
    public ProductBlock findLastRecord() {
        return blockChainService.findLastRecord();
    }
}
