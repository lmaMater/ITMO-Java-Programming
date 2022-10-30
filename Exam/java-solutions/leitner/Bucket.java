package leitner;

import java.util.ArrayList;
// :NOTE: * модификаторы доступа
public class Bucket {
    // :NOTE: не эффективное хранение слов
    private ArrayList<String> phrases;
    final private int number;
    final private double weight;

    public Bucket(int number) {
        this.number = number;
        weight = Math.pow((1.5), -number);
        phrases = new ArrayList<>();
    }

    public Bucket(int number, ArrayList<String> phrases) {
        this.number = number;
        weight = Math.pow((1.5), -number);
        this.phrases = phrases;
    }

    public void addPhrase(String phrase) {
        phrases.add(phrase);
    }

    public void removePhrase(String phrase) {
        // find phrase index
        for (int i = 0; i < phrases.size(); i++) {
            if (phrases.get(i).equals(phrase)) {
                phrases.remove(i);
                return;
            }
        }
    }

    public int getSize() {
        return phrases.size();
    }

    public double getWeight() {
        return weight;
    }

    public String getPhrase(int index) {
        return phrases.get(index);
    }
}
