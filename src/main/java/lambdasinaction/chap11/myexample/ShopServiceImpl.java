package lambdasinaction.chap11.myexample;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */
public class ShopServiceImpl implements ShopService {

    @Override
    public Product getPrice(String productName) {
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
        return product;
    }

    /**
     * 将同步方法转化成异步调用
     *
     * @param productName
     * @return
     */
    @Override
    public Future<Product> getPriceAsync(String productName) {
        return CompletableFuture.supplyAsync(() -> getPrice(productName));
    }



}
