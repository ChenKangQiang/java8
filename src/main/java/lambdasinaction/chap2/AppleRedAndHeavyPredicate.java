package lambdasinaction.chap2;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
