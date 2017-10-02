package lambdasinaction.chap11.myexample;

import java.util.concurrent.Future;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */
public interface ShopService {

    /**
     * 根据商品名查询商品信息
     *
     * @param productName
     * @return
     */
    Product getPrice(String productName);


    Future<Product> getPriceAsync(String productName);

}
