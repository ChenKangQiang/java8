package lambdasinaction.chap11.myexample;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */

public class Client {

    private static ShopService shopService;
    private static List<Integer> shopIds;

    @BeforeClass
    public static void before() {
        shopService = new ShopServiceImpl();
        shopIds = Arrays.asList(100, 101, 102, 103, 104);
    }


    @Test
    public void test1() {
        long start = System.nanoTime();
        Future<Product> futurePrice = shopService.getPriceAsync("myPhone", 1356);

        long incocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("异步调用直接返回: " + incocationTime + " ms");

        try {
            System.out.println("商品信息为: " + futurePrice.get(2000, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("获取价格的总处理时间: " + retrivalTime + " ms");
    }

    @Test
    public void test2() {
        long start = System.nanoTime();
        List<Product> futureProduct = shopService.batchQueryPrice("myPhone", shopIds);

        long incocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("批量查询异步调用: " + incocationTime + " ms");

    }

}
