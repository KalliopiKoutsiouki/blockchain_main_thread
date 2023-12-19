package com.warehouse.service;

import com.google.gson.Gson;
import com.warehouse.model.BlockDto;
import com.warehouse.model.ProductBlock;
import com.warehouse.model.ProductDto;
import com.warehouse.repository.BlockRepository;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * BlockChain service layer
 */
@Service
public class BlockChainServiceImpl implements BlockChainService{

    private int prefix = 5;

    @Autowired
    BlockRepository blockRepository;

    /**
     * Perfoms checks and saves a new block into the blockchain db
     * @param product
     */
    @Override
    public void save(ProductDto product) {
        ProductBlock productBlock = getProductBlock(product);
        blockRepository.save(productBlock);
    }

    public ProductBlock getProductBlock(ProductDto product) {
        addPreviousIdIfExists(product);
        String previousHash = getPreviousHash();
        BlockDto block = new BlockDto(previousHash, product );
        block.mineBlock(prefix);
        String blockJson = new Gson().toJson(block);
        ProductBlock productBlock = new ProductBlock(blockJson);
        return productBlock;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductBlock> productBlocks = blockRepository.findAll();
        List<ProductDto> products = productBlocks.stream().map(ProductBlock::extractBlockDto).map(blockDto -> blockDto.getProductData()).toList();
        return products;
    }

    @Override
    public ProductBlock getById(String id) {
        return null;
    }

    @Override
    public ProductBlock findLastRecord() {
        return null;
    }

    private void addPreviousIdIfExists(ProductDto product) {
        List<ProductBlock> allEntriesForProduct = blockRepository.findProductContainingCode(product.getProductCode());
        if (!allEntriesForProduct.isEmpty()) {
            ProductBlock pb = allEntriesForProduct.get(0);
            BlockDto lastBlockWithProduct = pb.extractBlockDto();
            String previousId = String.valueOf(lastBlockWithProduct.getProductData().getId());
            System.out.println(lastBlockWithProduct.getNonce() + lastBlockWithProduct.getProductData().getId());
            product.setPreviousID(previousId);
        }
    }

    private String getPreviousHash() {
        String previousHash = "0";
        ProductBlock previousBlock = blockRepository.findFirstByOrderByIdDesc();
        if (previousBlock != null) {
            BlockDto previous = previousBlock.extractBlockDto();
            previousHash = previous.getHash();
        }
        return previousHash;
    }
}
