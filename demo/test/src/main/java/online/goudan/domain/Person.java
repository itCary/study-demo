package online.goudan.domain;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/9/24 11:05
 */
public class Person extends Suppp {

    private String name;
    private int age;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("hello....");
    }

    public void say(String msg) {
        System.out.println(msg);
    }

    private Car getCar() {
        return car;
    }

    @MyAnnotation(desc = "de", name = "na")
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
