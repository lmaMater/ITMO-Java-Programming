import java.util.*;
import java.io.*;


public class ReverseSum2 {
    public static void main(String args[]) {
        try {
            MyScanner in = new MyScanner(System.in);
            in.checker = (ch)-> Character.isDigit(ch) || ch == '-';

            ArrayList<IntVector> nums = new ArrayList<IntVector>();
            int i = 0, currentNum, maxColumn = 0;

            try {
                while (!in.end()) {
                    nums.add(new IntVector());
                    int j = 0;
                    while (in.hasNextInLine()) {
                        currentNum = Integer.parseInt(in.next());
                        nums.get(i).pushBack(currentNum);
                        j++;
                    }
                    if (maxColumn < j) {
                        maxColumn = j;
                    }
                    i++;
                    in.nextLine();
                }
            } finally {
                in.close();
            }

            int columnSums[] = new int[maxColumn];
            int curElem = 0;

            for (i = 0; i < nums.size(); i++) {
                int rowLen = nums.get(i).getLength();

                for (int j = 0; j < rowLen; j++) {
                    currentNum = (int)nums.get(i).get(j);
                    columnSums[j] += currentNum;

                    if (j == 0) {
                    curElem = columnSums[0];
                    } else {
                        curElem = curElem + columnSums[j]; 
                    }

                    System.out.print(curElem + " ");
                }

                if (i < nums.size() - 1) {
                    System.out.println();
                }
            }

        } catch (final IOException e) {
            System.out.println("Cannot open file: " + e.getMessage());
        }
    }
}
