package online.goudan.main;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        /*Duck duck = new GreenHeadDuck();
        duck.setFlyBehavior(new GoodFlyBehavior());
        duck.setQuackBehavior(new GaGaQuackBehavior());
        duck.display();
        duck.fly();
        duck.quack();*/
        
        String s = "afalfjas";
        s.toCharArray();
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < nums.length; i++) {
                    int temp = target - nums[i];
                    if (map.containsKey(temp)) {
                        arr[0] = map.get(temp);
                        arr[1] = i;
                    }
                    map.put(nums[i], i);
                }
            }
        }).start();

        return arr;
    }
}
