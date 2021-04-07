package online.goudan;

import online.goudan.domain.Car;
import online.goudan.domain.Object2MapUtil;
import online.goudan.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘苟淡
 * @description 反射 api 练习
 * @date 2020/9/24 11:04
 */
public class ReflexTest {

    private Class<?> clazz;
    private Object person;

    @Before
    public void init() throws Exception {
        clazz = getClass().getClassLoader().loadClass("online.goudan.domain.Person");
        Person person = (Person) clazz.newInstance();
        person.setAge(12);
        person.setName("石器世界工");
        Car car = new Car();
        car.setColor("red");
        car.setName("aoaoaoa");
        person.setCar(car);
        this.person = person;
    }

    @Test
    public void test01() throws Exception {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("------------field------------");

        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("------------all field------------");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("------------method------------");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        System.out.println("------------给某一个成员变量设置值------------");
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "刘成龙");
        System.out.println(person);
        System.out.println("------------暴力获取某一个成员变量的值------------");

        Object o = name.get(person);
        System.out.println(o);

        System.out.println("------------调用某个方法------------");
        Method say = clazz.getDeclaredMethod("say", String.class);
        say.invoke(person, "lajfoafjajfoaj o");
    }

    /**
     * 通过反射调用无参方法
     *
     * @throws Exception
     */
    @Test
    @SuppressWarnings("all")
    public void test02() throws Exception {
        Method toString = clazz.getDeclaredMethod("toString");
        Object invoke = toString.invoke(person);
        System.out.println(invoke.getClass());
    }

    /**
     * 通过反射调用有参方法
     *
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        Method say = clazz.getDeclaredMethod("say", String.class);
        Object woaujgla = say.invoke(person, "woaujgla");
        System.out.println(woaujgla);
    }

    /**
     * 获取所有的成员变量
     */
    @Test
    public void test04() {
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] clazzFields = clazz.getFields();
        System.out.println(clazzFields.length);
        for (Field clazzField : clazzFields) {
            System.out.println(clazzField);
        }
    }

    /**
     * 获取方法
     */
    @Test
    public void test05() {
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------------声明的方法---------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println(declaredMethods.length);
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    @Test
    public void test06() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ReflexTest> clazz = ReflexTest.class;
        Method method = clazz.getDeclaredMethod("test02", null);
        Object invoke = method.invoke(this, null);
        System.out.println(invoke);
    }

    @Test
    public void test07() throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            Annotation[] annotations = method.getAnnotations();
            if (annotations.length > 0) {
                Arrays.stream(annotations).forEach(annotation -> System.out.println(annotation.annotationType().getSimpleName()));
            }
        });
    }

    @Test
    public void test08() throws Exception {
        Method setCar = clazz.getMethod("setCar", Car.class);
        Annotation[] annotations = setCar.getAnnotations();
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> clazz = annotation.annotationType();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName() + " = " + method.invoke(annotation));
            }
        }
    }

    @Test
    public void testO2M() {
        Person person = new Person();
        person.setName("石器世界工");
        person.setAge(12);
        Car car = new Car();
        car.setColor("red");
        car.setName("aoaoaoa");
        person.setCar(car);
        Map<String, Object> map = Object2MapUtil.object2Map(person);
        String ds = ds(map);
        System.out.println(ds);
    }

    private String ds(Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : map.keySet()) {
            Object o = map.get(s);
            if (o instanceof HashMap) {
                stringBuffer.append(s + " = {" + ds((Map<String, Object>) o) + "}");
            } else {
                stringBuffer.append(s + " = " + o + "\n");
                System.out.println(s + " = " + o);
            }
        }

        return stringBuffer.toString();
    }
}
