package leitner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary(String filename) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename),
                        StandardCharsets.UTF_8
                ))) {

            this.dictionary = new HashMap<String, String>();
            String line;

            while ((line = reader.readLine()) != null) {
                try (Scanner sc = new Scanner(line).useDelimiter(" - ")) {
                    try {
                        // :NOTE: * словосочетания
                        String phrase = sc.next();
                        String translation = sc.next();
                        dictionary.put(phrase, translation);
                    } catch (NoSuchElementException e) {
                        System.out.println("Wrong file format: " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }

    public String translate(String phrase) {
        if (dictionary.containsKey(phrase)) {
            return dictionary.get(phrase);
        } else {
            throw new AssertionError("No such phrase in dictionary.");
        }
    }

    public ArrayList<String> fillFirstBucket() {
        ArrayList<String> firstBucket = new ArrayList<String>();
        for (String phrase : dictionary.keySet()) {
            firstBucket.add(phrase);
        }
        return firstBucket;
    }

}
