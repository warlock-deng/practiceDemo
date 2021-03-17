package reflect;

import java.lang.reflect.Method;

/**
 * @author warlock.deng
 * Created at 2020/8/21
 */
public class ReflectMain {

    public static void main(String[] args) throws Exception {

        Class rb = Class.forName("reflect.Robot");

        Robot robot = (Robot) rb.newInstance();

        Method hello = rb.getDeclaredMethod("getHello2", String.class);
        hello.setAccessible(true);
        Object hv = hello.invoke(robot, "test");

        System.out.println(hv);

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));


    }


}
