package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/20 17:37
 * @Description :
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);

    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
