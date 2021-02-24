package online.goudan.domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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
        Class<? extends Car> clazz = this.getClass();
        Car car = null;
        try {
            car = clazz.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    if ("color".equals(field.getName())) {
                        field.set(car, "黑色");
                        continue;
                    }
                    Object o = field.get(this);
                    field.set(car, o);

                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}' + "@" + Integer.toHexString(hashCode());

    }

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
