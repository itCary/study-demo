package online.goudan.cglib;

/**
 * @author chenglongliu
 * @date 2021/2/24 19:16
 * @desc 无接口的类
 */
public class Person {
    @Deprecated
    public void sayHello(){
        System.out.println("hello");
    }

    public void sayHi(){
        System.out.println("hi");
    }
}
