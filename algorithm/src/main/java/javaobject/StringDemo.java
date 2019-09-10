package javaobject;


import java.util.Stack;

/**
 * @author Warlock.deng
 * Created at 2019-09-04
 */
public class StringDemo {

    public static void main(String[] args) {

        src.main.java.javaobject.TestDemo testDemo = new src.main.java.javaobject.TestDemo();

        Integer i1 = 10;
        Integer i10 = 10;
        boolean b1 = (i1 == i10);

        Integer i2 = 190;
        Integer i20 = 190;
        boolean b2 = i2 == i20;

        String s = "abcdefghijklmnopqrstuvwxyz---abcdefghijklmnopqrstuvwxyz&&&****()";
        int hashCode = s.hashCode();

        int h = hashCode(s);


        String a = "";
    }

    private static void stat() {
        Stack<String> stack = new Stack<>();


    }

    private static int hashCode(String s) {
        int h = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            h = (h << 5) - h + c;
        }
        return h;
    }


}
