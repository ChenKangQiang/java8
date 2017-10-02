package lambdasinaction.chap11;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static lambdasinaction.chap11.Util.delay;
import static lambdasinaction.chap11.Util.format;

public class AsyncShop {

    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    /**
     * 异步获取商品价格
     * 这里是手工开辟一个线程
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync1(String product) {

        //让future去等待计算结果
        final CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        //手工开辟一个线程
        new Thread( () -> {
                    try {
                        double price = calculatePrice(product);
                        futurePrice.complete(price);
                    } catch (Exception ex) {
                        futurePrice.completeExceptionally(ex);
                    }
        }).start();
        return futurePrice;
    }

    /**
     * 异步计算价格
     * 使用supplyAsync，无需手工开辟线程
     *
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync2(String product) {

        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        if (StringUtils.isEmpty(product)) {
            throw new RuntimeException("product not available");
        }
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

}