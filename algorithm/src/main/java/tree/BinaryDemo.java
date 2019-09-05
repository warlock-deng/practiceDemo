package src.main.java.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Warlock.deng
 * Created at 2019-09-04
 */
public class BinaryDemo {
    public static void main(String[] args) {
        Integer[] tg = {50, 12, 65, 8, 23, 69, 99, 56, 65, 18, 12, 21, 2, 10, 7, 24};
        List<Integer> list = Arrays.stream(tg).collect(Collectors.toList());
        Collections.sort(list);

    }


}
