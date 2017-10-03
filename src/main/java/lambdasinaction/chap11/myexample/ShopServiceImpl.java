package lambdasinaction.chap11.myexample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */
public class ShopServiceImpl implements ShopService {

    @Override
    public Product getPrice(String productName, Integer shopId) {
        Random random = new Random(productName.charAt(0) * productName.charAt(1) * productName.charAt(2));

        //模拟远程调用及处理时长
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(new BigDecimal(random.nextDouble() * productName.charAt(0) + ""));
        product.setDiscountEnum(DiscountEnum.BigDiscount);
        product.setShopId(shopId);
        return product;
    }

    /**
     * 将同步方法转化成异步调用
     *
     * @param productName
     * @return
     */
    @Override
    public Future<Product> getPriceAsync(String productName, Integer shopId) {
        return CompletableFuture.supplyAsync(() -> getPrice(productName, shopId));
    }

    /**
     * 批量查询输入商户中某个商品的价格
     *
     * @param productName
     * @param shopIds
     * @return
     */
    @Override
    public List<Product> batchQueryPrice(String productName, List<Integer> shopIds) {
        /*
        return shopIds.stream()
                .map(shopId -> getPrice(productName, shopId))
                .collect(Collectors.toList());
                */

        return shopIds.parallelStream()
                .map(shopId -> getPrice(productName, shopId))
                .collect(Collectors.toList());
    }




}
