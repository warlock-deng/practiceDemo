package StrategyPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 11:44
 * @Description :
 */
public class CashContext {
    private CashSuper cs;


    public CashContext(String type) {
        switch (type) {
            case "正常":
                CashNormal cashNormal = new CashNormal();
                cs = cashNormal;
                break;
            case "满300减100":
                CashReturn cashReturn = new CashReturn(300, 100);
                cs = cashReturn;
                break;
            case "打8折":
                CashRebate cashRebate = new CashRebate(0.8);
                cs = cashRebate;
                break;
            default:
                break;

        }
    }


    public double getResult(double money) {
        return cs.acceptCash(money);
    }

}
