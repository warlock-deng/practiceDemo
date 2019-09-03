package ObserverPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/20 17:40
 * @Description :
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver:" + Integer.toBinaryString(subject.getState()));
    }

}
