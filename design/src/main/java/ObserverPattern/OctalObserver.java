package ObserverPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/20 17:41
 * @Description :
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("OctalObserver:" + Integer.toOctalString(this.subject.getState()));
    }


}
