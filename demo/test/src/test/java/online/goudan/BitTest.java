package online.goudan;

import org.junit.Test;

/**
 * @author chenglongliu
 * @date 2021/3/3 10:13
 * @desc 位运算
 */
public class BitTest {

    @Test
    public void test01() {
        int b = 12;
        long i = ((long) b << 32) + ((long) b << 16);
        System.out.printf("Math.round(15/2f)=%d", Math.round(15 / 2f));
    }

    @Test
    public void test02() {
        String old = "V1.0.127";
        String current = "IJOIN_101V1.12.5";
        String[] oldVersions = old.substring(old.lastIndexOf("V") + 1).split("\\.");
        byte ox = Byte.parseByte(oldVersions[0]);
        byte oy = Byte.parseByte(oldVersions[1]);
        byte oz = Byte.parseByte(oldVersions[2]);
        String[] currentVersions = current.substring(current.lastIndexOf("V") + 1).split("\\.");
        byte nx = Byte.parseByte(currentVersions[0]);
        byte ny = Byte.parseByte(currentVersions[1]);
        byte nz = Byte.parseByte(currentVersions[2]);

        int oldV = (ox << 16) + (oy << 8) + oz;
        int newV = (nx << 16) + (ny << 8) + nz;
        System.out.println("oldV=" + oldV + ", newV=" + newV);
        System.out.println(newV > oldV);
    }

    @Test
    public void test03() {
        String old = "1142V1.0.126";
        String current = "IJOIN_101V1.12.5";
        String v = old.substring(old.lastIndexOf("V"));
        System.out.println(v);
        int oHash = v.hashCode();
        String v1 = current.substring(current.lastIndexOf("V"));
        System.out.println(v1);
        int nHash = v1.hashCode();
        System.out.println(nHash > oHash);
    }
}
