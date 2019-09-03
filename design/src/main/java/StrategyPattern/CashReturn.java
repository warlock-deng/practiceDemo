package StrategyPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 15:28
 * @Description :
 */
public class CashReturn extends CashSuper {

    private double full;

    private double minus;

    public CashReturn() {
    }

    public CashReturn(double full, double minus) {
        this.full = full;
        this.minus = minus;
    }

    public double acceptCash(double money) {
        if (money > full) {
            money = money - minus;
        }
        return money;
    }

}
