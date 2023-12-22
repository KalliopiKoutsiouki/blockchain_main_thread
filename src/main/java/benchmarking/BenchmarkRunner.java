package benchmarking;

import com.warehouse.model.BlockDto;
import com.warehouse.model.ProductBlock;
import com.warehouse.model.ProductDto;
import com.warehouse.service.BlockChainServiceImpl;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {

    private static ProductDto genesisProductData = new ProductDto("123", "productName", 3, "this is for benchmarking", "benchmarking");
//    private static BlockDto genesisBlock = new BlockDto("0", productData);

    public static void main(String[] args) throws IOException {

    }
    @Benchmark
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    private static void saveBlock(BlockChainServiceImpl service, ProductDto productData) {
        service.save(productData);
    }

    private static void saveAll (List<ProductDto> productDtoList) {

    }

}
