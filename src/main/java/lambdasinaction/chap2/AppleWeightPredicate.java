package lambdasinaction.chap2;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */
public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
