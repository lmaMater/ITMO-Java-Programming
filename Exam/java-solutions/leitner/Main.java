package leitner;

import java.util.Scanner;

// :NOTE: # сохраннее по корзинам после остановки программы

public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary("dictionary.txt");

        Bucket[] buckets = new Bucket[10];

        // if data file is empty
        buckets[0] = new Bucket(1, dict.fillFirstBucket());
        for (int i = 1; i < 10; i++) {
            buckets[i] = new Bucket(i + 1);
        }
        // if user played before
        // ...

        System.out.println("Let's start!");


        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                Randomizer rand = new Randomizer(buckets);
                int bucketNumber = rand.randomBucket();
                int phraseIndex = rand.randomPhraseIndex(bucketNumber);
                String curPhrase = buckets[bucketNumber].getPhrase(phraseIndex);

                System.out.println("Current bucket: " + (bucketNumber + 1));
                System.out.println("Translate next word:");
                System.out.println(curPhrase);

                String answer = sc.nextLine();
                if (answer.equals("")) {
                    break;
                } else {
                    if (answer.equalsIgnoreCase(dict.translate(curPhrase))) {
                        System.out.println("Right!");
                        // move upper
                        if (bucketNumber != 9) {
                            buckets[bucketNumber].removePhrase(curPhrase);
                            buckets[bucketNumber + 1].addPhrase(curPhrase);
                        }
                    } else {
                        System.out.println("Wrong!");
                        // move to first bucket
                        if (bucketNumber != 0) {
                            buckets[bucketNumber].removePhrase(curPhrase);
                            buckets[0].addPhrase(curPhrase);
                        }
                    }
                }
            }
        }

        System.out.println("Good game, see you later!");

    }
}
