package ObserverPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/20 17:38
 * @Description :
 */
public abstract class Observer {

    protected Subject subject;


    public abstract void update();
}
