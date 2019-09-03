package StatePattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 15:57
 * @Description : 状态模式
 */
public class DemoMain {

    public static void main(String[] args) {

        Context context = new Context();


        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        EndState endState = new EndState();
        endState.doAction(context);

        System.out.println(context.getState().toString());

    }

}
