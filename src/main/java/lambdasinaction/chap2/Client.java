package lambdasinaction.chap2;

import java.util.Arrays;
import java.util.List;

import static lambdasinaction.chap2.FilteringApples.filter;
import static lambdasinaction.chap2.FilteringApples.filterApplesByColor;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */
public class Client {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApplesByColor(inventory, "green");
        System.out.println(greenApples);

        // [Apple{color='red', weight=120}]
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        // []
        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        // 使用匿名类，这样就不需要写多个实现类，但是还是存在许多模板方法
        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            public boolean test(Apple a) {
                return a.getColor().equals("red");
            }
        });
        System.out.println(redApples2);

        // 使用lambda表达式
        List<Apple> yellowApple = filter(inventory, (Apple apple) -> "yellow".equals(apple.getColor()));
    }

}
