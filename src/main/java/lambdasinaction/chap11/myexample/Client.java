package lambdasinaction.chap11.myexample;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */
public class Client {

    public static void main(String[] args) {
        ShopService shopService = new ShopServiceImpl();
        long start = System.nanoTime();
        Future<Product> futurePrice = shopService.getPriceAsync("myPhone");

        long incocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + incocationTime + " msecs");

        try {
            System.out.println("Price is " + futurePrice.get(2000, TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrivalTime + " msecs");
    }

}
