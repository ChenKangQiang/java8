package lambdasinaction.chap11.myexample;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */

@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 5687419850185901501L;
    private String productName;
    private BigDecimal price;
    private DiscountEnum discountEnum;
}
