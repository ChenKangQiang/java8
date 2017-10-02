package lambdasinaction.chap11.myexample;

import java.math.BigDecimal;

/**
 * @Author chenkangqiang
 * @Data 2017/10/2
 */
public enum  DiscountEnum {

    NoDiscount(new BigDecimal("0"), "无优惠"),
    SmallDiscount(new BigDecimal("0.15"), "优惠15%"),
    MidDiscount(new BigDecimal("0.30"), "优惠30%"),
    BigDiscount(new BigDecimal("0.50"), "优惠50%");

    private BigDecimal discount = new BigDecimal("0");
    private String description = "无优惠";

    private DiscountEnum(BigDecimal discount, String description) {
        this.discount = discount;
        this.description = description;
    }


}
