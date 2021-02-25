package online.goudan.jdk;

/**
 * @author chenglongliu
 * @date 2021/2/25 13:33
 * @desc Man
 */
public class Man implements Behavior {
    @Override
    public void say() {
        System.out.println("我是一个man");
    }

    @Override
    public void run() {
        System.out.println("我跑得很快");
    }

    @Override
    public void jump() {
        System.out.println("我跳得很高");
    }
}
