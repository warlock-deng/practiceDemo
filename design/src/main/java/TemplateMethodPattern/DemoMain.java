package TemplateMethodPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/26 14:15
 * @Description : 模板方法模式  定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 */
public class DemoMain {

    public static void main(String[] args) {
        TestPaper testPaper = new Persion1();
        testPaper.testQuestion1();
        testPaper.testQuestion2();
        testPaper.testQuestion3();

        TestPaper testPaper1 = new Persion2();
        testPaper1.testQuestion1();
        testPaper1.testQuestion2();
        testPaper1.testQuestion3();

    }

}
