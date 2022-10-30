public class PairStringInt {
    private final String str;
    private final int num;

    public PairStringInt(final String str, final int num) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public int getNum() {
        return num;
    }

    public PairStringInt setStr(String str) {
        return new PairStringInt(str, num);
    }
    
    public PairStringInt setNum(int num) {
        return new PairStringInt(str, num);
    }
}