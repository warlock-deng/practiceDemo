package ObserverPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/20 17:37
 * @Description :观察者模式（状态变更通知）
 * 观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态发生变化时，会通知所有观察者对象，使它们能够自动更新自己。
 */
public class DemoMain {

    public static void  main(String[] args){
        Subject subject=new Subject();

        new BinaryObserver(subject);
        new HexaObserver(subject);
        new OctalObserver(subject);

        subject.setState(15);

        subject.setState(10);
    }

}
