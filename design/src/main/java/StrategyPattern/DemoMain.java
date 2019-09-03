package StrategyPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 11:33
 * @Description :策略模式
 */
public class DemoMain {


    public static void main(String[] args) {
        CashContext cashContext = new CashContext("打8折");
        double res = cashContext.getResult(1286);


        int a=0;
    }


}
