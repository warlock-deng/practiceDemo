package Prototype;


/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/26 13:37
 * @Description :
 */
public class WorkExperience implements Cloneable {

    private String time;

    private String company;

    public WorkExperience() {

    }

    public WorkExperience(String time, String company) {
        this.time = time;
        this.company = company;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
