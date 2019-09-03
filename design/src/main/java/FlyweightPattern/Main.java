package FlyweightPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/14 10:58
 * @Description :享元模式（减少对象创建数量）
 */
public class Main {

    private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getInstance(getColor());
            circle.setX(getX());
            circle.setY(getY());
            circle.setRadius(getRadius());
            circle.draw();
        }
    }

    private static String getColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getX() {
        return (int) (Math.random() * 100);
    }

    private static int getY() {
        return (int) (Math.random() * 100);
    }

    private static int getRadius() {
        return (int) (Math.random() * 100);
    }
}
