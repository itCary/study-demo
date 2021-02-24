package online.goudan;

import online.goudan.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 刘苟淡
 * @description 反射 api 练习
 * @date 2020/9/24 11:04
 */
public class ReflexTest {

    private Class<?> clazz;
    private Person person;

    @Before
    public void init() throws Exception {
        clazz = getClass().getClassLoader().loadClass("online.goudan.domain.Person");
        person = (Person) clazz.newInstance();
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
}
