package StatePattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 16:02
 * @Description :
 */
public class EndState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is end state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "end state";
    }

}
