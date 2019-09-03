package StrategyPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 15:27
 * @Description :
 */
public class CashRebate extends CashSuper {

    private double rebate;

    public CashRebate() {
    }

    public CashRebate(double rebate) {
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double money) {

        return money * rebate;
    }

}
