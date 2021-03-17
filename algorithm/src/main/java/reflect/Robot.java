package reflect;

/**
 * @author warlock.deng
 * Created at 2020/8/21
 */
public class Robot {

    private String name;

    private String getHello() {
        return "hello " + name;
    }

    private String getHello2(String ts) {
        return ts + " hello " + name;
    }

    public String throwHello() {
        return "throw hello " + name;
    }

    public String throwHello(String ts) {
        return ts + " throw hello " + name;
    }

}
