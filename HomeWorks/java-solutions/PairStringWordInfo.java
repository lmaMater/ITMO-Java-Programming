public class PairStringWordInfo {
    String str;
    WordInfo info;

    PairStringWordInfo(String str, WordInfo info) {
        this.str = str;
        this.info = info;
    }
    
    String getStr() {
        return str;
    }

    WordInfo getInfo() {
        return info;
    }
}