package online.goudan.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chenglongliu
 * @date 2021/2/24 19:16
 * @desc cglib动态代理的client
 */
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                Annotation[] annotations = method.getAnnotations();
                if (annotations.length > 0) {
                    if (Arrays.stream(annotations)
                            .map(annotation -> annotation.annotationType().getSimpleName())
                            .filter(s -> "Deprecated".equals(s))
                            .toArray()
                            .length > 0) {
                        System.out.println("before");
                        Object o = proxy.invokeSuper(obj, args);
                        System.out.println("after");
                        return o;
                    }
                }
                return proxy.invokeSuper(obj, args);

            }
        });
        Person person = (Person) enhancer.create();
        person.sayHi();
        person.sayHello();
    }
}
