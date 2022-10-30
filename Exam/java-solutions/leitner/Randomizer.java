package leitner;

import java.util.Random;

public class Randomizer {
    private double overallWeight;
    private final Random random;
    private final double randomNumber;
    private final Bucket[] buckets;

    public Randomizer(Bucket[] buckets) {
        this.buckets = buckets;
        this.random = new Random();
        overallWeight = 0.0;
        for (Bucket bucket : buckets) {
            overallWeight += (double) bucket.getSize() * bucket.getWeight();
        }
        randomNumber = random.nextDouble() * overallWeight;
    }


    public int randomBucket() {
        double counter = 0.0;
        for (int i = 0; i < 10; i++) {
            if (randomNumber <= counter
                    + buckets[i].getWeight() * buckets[i].getSize()) {
                return i;
            } else {
                counter += buckets[i].getWeight() * buckets[i].getSize();
            }
        }
        throw new AssertionError("No such bucket");
    }
    // :NOTE: * случайная корзина (пропорционально), а в ней случайное число -- даст ли нужную вероятность?
    public int randomPhraseIndex(int bucketNumber) {
        return random.nextInt(buckets[bucketNumber].getSize());
    }
}
