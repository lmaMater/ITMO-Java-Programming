import java.io.*;
import java.util.*;


public class Reverse {
    public static void main(String args[]) {
        try {
            MyScanner in = new MyScanner(System.in);
            in.checker = (ch)-> Character.isDigit(ch) || ch == '-';

            ArrayList<IntVector> arr = new ArrayList<IntVector>(); 
            try {
                int index = -1;
                while (!in.end()) {
                    arr.add(new IntVector());
                    index++;
                    while (in.hasNextInLine()) {
                        arr.get(index).pushBack(Integer.parseInt(in.next()));
                    }
                    in.nextLine();
                }

                for (int i = arr.size() - 2; i >= 0; i--) {
                    for (int j = arr.get(i).getLength() - 1; j >= 0; j--) {
                        System.out.print(arr.get(i).get(j) + " ");
                    }
                    System.out.println();
                }

            } finally {
                in.close();
            }
        } catch (final IOException e) {
            System.out.println("Cannot open file: " + e.getMessage());
        } 
    }
}