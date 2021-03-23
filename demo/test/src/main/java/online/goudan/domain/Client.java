package online.goudan.domain;

/**
 * @author chenglongliu
 * @date 2021/3/19 23:35
 * @desc Client
 */
public class Client {
    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int sum = 0;
                    for (int i = 0; i < 1000; i++) {
                        sum += i;
                    }
                    System.out.println(sum);
                }
            }).start();
        }
    }
}
