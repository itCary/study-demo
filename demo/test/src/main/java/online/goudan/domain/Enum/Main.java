package online.goudan.domain.Enum;

public class Main {
    public void age(Age ag) {
        switch (ag) {
            case _12:
                break;
            case _16:
                break;
            case _19:
                break;
            default:
                break;
        }
    }

    public void age(int ag) {
        switch (ag) {
            case 12:
                break;
            case 16:
                break;
            case 19:
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        long t = 0, limit = 1000000;
        Main mm = new Main();

        t = System.currentTimeMillis();
        for (long i = 0; i < limit; i++) {
            mm.age(16);
        }
        System.out.println("耗时" + (System.currentTimeMillis() - t) + "ms");


        t = System.currentTimeMillis();

        for (long i = 0; i < limit; i++) {
            mm.age(Age._16);
        }
        System.out.println("耗时" + (System.currentTimeMillis() - t) + "ms");
    }
}