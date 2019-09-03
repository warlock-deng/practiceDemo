package StrategyPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 11:45
 * @Description :
 */
public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }



}
