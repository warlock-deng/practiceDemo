package BuilderPattern;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/26 16:58
 * @Description : 建行者模式 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * 指挥者  建造者抽象类，
 */
public class DemoMain {

    public static void main(String[] args) {

        Map<String, Object> mapTem = new HashMap<>();

        Map<String, Object> map = new HashMap<>();
        map.put("a", 0);

        mapTem = map;

        map.put("b", 1);

    }

}
