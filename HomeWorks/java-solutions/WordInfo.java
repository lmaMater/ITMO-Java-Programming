public class WordInfo {
    int counter;
    int curString;
    int curStringCounter;
    IntVector indexes;

    WordInfo(int counter, int curString, int curStringCounter) {
        this.counter = counter;
        this.curString = curString;
        this.curStringCounter = curStringCounter;
        this.indexes = new IntVector();
    }

    void toStringBuilder(StringBuilder sb) {
        for (int i = 0; i < indexes.getLength(); i++) {
            sb.append(" ");
            sb.append(indexes.get(i));
        }
    }

    void printInfo(StringBuilder sb) {
        sb.append(" ");
        sb.append(counter);
        for (int i = 0; i < indexes.getLength(); i++) {
            sb.append(" ");
            sb.append(indexes.get(i));
        }
    }
}