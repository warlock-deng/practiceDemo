package FactoryPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/1/15 15:54
 * @Description :
 */
public class ShapeFactory {


    public static Shape getShape(String shape) {
        switch (shape) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                throw new IllegalArgumentException("没有可用的对象");
        }
    }


}
