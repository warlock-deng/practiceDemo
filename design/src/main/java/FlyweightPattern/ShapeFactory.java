package FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/14 10:52
 * @Description :
 */
public class ShapeFactory {

    private static Map<String, Shape> map = new HashMap<>();

    public static Shape getInstance(String color) {
        Shape shape = map.get(color);
        if (null == shape) {
            shape = new Circle(color);
            map.put(color, shape);
        }
        return shape;
    }

}
