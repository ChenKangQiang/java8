package lambdasinaction.chap2;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */
public class AppleColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
