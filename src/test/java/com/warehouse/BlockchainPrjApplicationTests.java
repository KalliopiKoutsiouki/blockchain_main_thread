package com.warehouse;

import com.google.gson.Gson;
import com.warehouse.model.BlockDto;
import com.warehouse.model.ProductBlock;
import com.warehouse.model.ProductDto;
import com.warehouse.repository.BlockRepository;
import com.warehouse.service.BlockChainService;
import com.warehouse.service.BlockChainServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@SpringBootTest
class BlockchainPrjApplicationTests {

    @Mock
    BlockRepository blockRepository;

    @InjectMocks
    BlockChainServiceImpl service;
    @Test
    void testSave() {
        ProductDto productDto = new ProductDto( "1111", "firstProduct", 3, "this is the first product", "skincare");
        ProductBlock expectedProductBlock = new ProductBlock();
        expectedProductBlock.setBlockJson("testBlockJson");

        when(service.getProductBlock(productDto)).thenReturn(expectedProductBlock);
        when(blockRepository.save(ArgumentMatchers.argThat(
                productBlock -> productBlock.getBlockJson().equals(expectedProductBlock.getBlockJson()))
        )).thenReturn(expectedProductBlock);

        service.save(productDto);
        verify(blockRepository).save(ArgumentMatchers.argThat(
                productBlock -> productBlock.getBlockJson().equals(expectedProductBlock.getBlockJson()))
        );

    }

}
