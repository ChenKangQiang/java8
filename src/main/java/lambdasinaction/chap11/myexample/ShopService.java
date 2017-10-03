package lambdasinaction.chap11.myexample;

import java.util.List;
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
    Product getPrice(String productName, Integer shopId);


    Future<Product> getPriceAsync(String productName, Integer shopId);


    List<Product> batchQueryPrice(String productName, List<Integer> shopIds);

}
