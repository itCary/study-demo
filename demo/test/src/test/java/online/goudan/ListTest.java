package online.goudan;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author 刘苟淡
 * @description
 * @date 2020/10/9 10:39
 */
public class ListTest {
    @Test
    public void test01() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addLast("a");
        linkedList.addLast("b");
        linkedList.addLast("c");
        linkedList.addLast("d");
        linkedList.addLast("1");
        linkedList.addLast("2");
        linkedList.addLast("3");
        linkedList.addLast("4");
        linkedList.remove("1");
        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}
