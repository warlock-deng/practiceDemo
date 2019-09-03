package StatePattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 15:58
 * @Description :
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "start state";
    }

}
