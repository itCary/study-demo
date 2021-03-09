package online.goudan;

import online.goudan.domain.Person;
import org.junit.Test;

/**
 * @author chenglongliu
 * @date 2020/12/30 09:30
 * @desc Math 类的 demo
 */
public class MathTest {

    @Test
    public void testToRadians() {
        double v_10 = Math.toRadians(-10);
        double v_370 = Math.toRadians(370);
        double sin10 = Math.sin(v_10);
        double sin370 = Math.sin(v_370);

        System.out.printf("v10:%f,v370:%f%n", sin10, sin370);
    }

    @Test
    public void test01() {
        double pow = Math.pow(4, 2);
        System.out.println(pow);
        double sqrt = Math.sqrt(4);
        System.out.println(sqrt);
        double cbrt = Math.cbrt(8);
        System.out.println(cbrt);
        double pow1 = Math.pow(8, 1 / 3);
        System.out.println(pow1);

        System.out.printf("%.1f%n", 2141.16141f);
        float x = 1;
        float ex = 2;
        float y = 2;
        float ey = 1;
        String format = String.format("%.2f",
                Math.sqrt(
                        Math.pow(x - ex, 2) + Math.pow(y - ey, 2)
                )
        );
        System.out.println(format);
    }

    public void changeStr(String string) {
        string = "abc";
        System.out.println(string);
    }

    public void changeObject(Person person) {
        person = new Person();
        person.setAge(23);
        person.setName("abc");
        System.out.println("change=" + person);
    }

    @Test
    public void test02() {
        String dd = "123";
        MathTest mathTest = new MathTest();
        mathTest.changeStr(dd);
        System.out.println("dd=" + dd);

        Person person = new Person();
        person.setName("123");
        person.setAge(21);
        System.out.println(person);
        mathTest.changeObject(person);
        System.out.println(person);
    }
}
