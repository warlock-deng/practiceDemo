package Prototype;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/26 13:31
 * @Description : 原型模型 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 */
public class DemoMain {

    public static void main(String[] args) {

        Resume resume = new Resume();
        resume.setName("ddd");
        resume.setAge("10");
        resume.setSex("男");
        resume.setWorkExperience(new WorkExperience("2012-2015", "company1"));



        try {
            Resume resume1 = (Resume) resume.clone();
            resume1.setWorkExperience(new WorkExperience("2010-2014","adasdf"));

            resume1.display();

        } catch (Exception ex) {
        }

        resume.display();

    }

}
