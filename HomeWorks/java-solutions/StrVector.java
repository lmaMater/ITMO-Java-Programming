import java.util.*;


public class StrVector {
    private String vector[];
    private int length;
    private int currentIndex;

    public StrVector() {
        length = 1;
        vector = new String[length];
        currentIndex = -1; 
    }

    public int getLength() {
        return currentIndex + 1;
    }

    public void pushBack(String element) {
        currentIndex += 1;

        if (currentIndex == length) {
            length *= 2;
            vector = Arrays.copyOf(vector, length); 
        }

        vector[currentIndex] = element;
    }

    public String get(int index) {
        return vector[index];
    }
}