package online.goudan.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenglongliu
 * @date 2021/2/25 13:32
 * @desc jdk动态代理的client
 */
public class Client {
    public static void main(String[] args) {
        Man man = new Man();
        Behavior proxyInstance = (Behavior) Proxy.newProxyInstance(man.getClass().getClassLoader(),
                man.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     *
                     * @param proxy 代理对象
                     * @param method 当前调用的方法
                     * @param args 当前调用的方法的参数
                     * @return 代理结果返回
                     * @throws Throwable 异常
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName());
                        Object o = method.invoke(man, args);
                        System.out.println(o);
                        return o;

                    }
                });

        proxyInstance.say();
    }
}
