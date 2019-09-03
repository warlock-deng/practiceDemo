package Prototype;

import java.text.MessageFormat;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/26 13:31
 * @Description :
 */
public class Resume implements Cloneable {

    private String name;

    private String sex;

    private String age;

    private WorkExperience workExperience;

    public void display() {
        System.out.println(MessageFormat.format("{0} {1} {2}", name, sex, age));
        System.out.println(MessageFormat.format("workExperience:{0}  {1}", workExperience.getTime(), workExperience.getCompany()));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience = workExperience;
    }
}
