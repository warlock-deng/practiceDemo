package FactoryPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/1/15 16:00
 * @Description :
 */
public class FactoryPattern {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("circle");
        circle.draw();

        Shape rectangle = ShapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = ShapeFactory.getShape("square");
        square.draw();

    }


}
