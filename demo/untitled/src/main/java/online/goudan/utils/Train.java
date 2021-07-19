package online.goudan.utils;

/**
 * @author 刘成龙
 * @date 2021/7/5 16:02
 * @desc Car
 */
public class Car {
    private String name;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
