package online.goudan.pojo;

/**
 * @author chenglongliu
 * @date 2021/4/14 21:52
 * @desc Fish
 */
public class Fish {

    @Override
    public String toString() {
        return "Fish{" +
                "d='" + d + '\'' +
                ", i='" + i + '\'' +
                ", rid=" + rid +
                ", u='" + u + '\'' +
                ", ru='" + ru + '\'' +
                ", ac='" + ac + '\'' +
                ", rpc='" + rpc + '\'' +
                ", pc='" + pc + '\'' +
                ", pt=" + pt +
                ", oct=" + oct +
                ", dur=" + dur +
                ", pro='" + pro + '\'' +
                ", ct='" + ct + '\'' +
                ", e=" + e +
                ", av='" + av + '\'' +
                ", up='" + up + '\'' +
                '}';
    }

    private String d;
    private String i;
    private int rid;
    private String u;
    private String ru;
    private String ac;
    private String rpc;
    private String pc;
    private long pt;
    private long oct;
    private int dur;
    private String pro;
    private String ct;
    private EDTO e;
    private String av;
    private String up;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getRpc() {
        return rpc;
    }

    public void setRpc(String rpc) {
        this.rpc = rpc;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public long getPt() {
        return pt;
    }

    public void setPt(long pt) {
        this.pt = pt;
    }

    public long getOct() {
        return oct;
    }

    public void setOct(long oct) {
        this.oct = oct;
    }

    public int getDur() {
        return dur;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public EDTO getE() {
        return e;
    }

    public void setE(EDTO e) {
        this.e = e;
    }

    public String getAv() {
        return av;
    }

    public void setAv(String av) {
        this.av = av;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public static class EDTO {
        private String rac;
        private int fps;
        private String ver;
        private int dv;

        public EDTO(String rac, int fps, String ver, int dv) {
            this.rac = rac;
            this.fps = fps;
            this.ver = ver;
            this.dv = dv;
        }

        public String getRac() {
            return rac;
        }

        public void setRac(String rac) {
            this.rac = rac;
        }

        public int getFps() {
            return fps;
        }

        public void setFps(int fps) {
            this.fps = fps;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public int getDv() {
            return dv;
        }

        public void setDv(int dv) {
            this.dv = dv;
        }
    }
}
