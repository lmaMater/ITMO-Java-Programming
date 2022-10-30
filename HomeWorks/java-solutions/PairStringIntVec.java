import java.util.*;


class PairStringIntVec {
    private final String str;
    private final IntVector intVec;

    public PairStringIntVec(String str, IntVector intVec) {
        this.str = str;
        this.intVec = intVec;
    }

    public String getStr() {
        return str;
    }

    public IntVector getVec() {
        return intVec;
    }

    public PairStringIntVec setStr (String str) {
        return new PairStringIntVec(str, intVec);
    }

    public PairStringIntVec setIntVec (IntVector intVec) {
        return new PairStringIntVec(str, intVec);
    }

    public String vecToString(int begin) {
        StringBuilder out = new StringBuilder();
        for (int i = begin; i < intVec.getLength(); i++) {
            out.append(" ");
            out.append(intVec.get(i));
        }
        return out.toString();
    }
}