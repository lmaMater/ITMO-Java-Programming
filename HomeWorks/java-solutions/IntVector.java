import java.util.*;


public class IntVector {
    private int vector[];
    private int currentIndex;

    public IntVector() {
        vector = new int[1];
        currentIndex = -1; 
    }

    public int getLength() {
        return currentIndex + 1;
    }

    public void pushBack(int element) {
        currentIndex += 1;

        if (currentIndex == vector.length) {
            vector = Arrays.copyOf(vector, 2 * vector.length); 
        }

        vector[currentIndex] = element;
    }

    public int get(int index) {
        return vector[index];
    }
    
    public void set(int index, int value) {
        vector[index] = value;
    }
}