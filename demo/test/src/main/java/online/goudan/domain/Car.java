package online.goudan.domain;

import java.io.Serializable;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/24 16:58
 */
public class Car implements Cloneable, Serializable {
    private static final long serialVersionUID = -442327705861833418L;

    private String color;
    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
/*
    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }*/

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
