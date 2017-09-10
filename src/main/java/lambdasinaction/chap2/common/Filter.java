package lambdasinaction.chap2.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenkangqiang
 * @Data 2017/9/10
 */

public class Filter {

    /**
     * 过滤器的泛型过滤方法，从而可以过滤苹果类、橘子类等
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


}
