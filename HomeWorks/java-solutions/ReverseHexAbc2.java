import java.io.*;
import java.util.*;


public class ReverseHexAbc2 {
    public static boolean isHex(String s) {
        return s.startsWith("0x");
    }

    public static int hexToDec(String s, int shift) {
        if (s.length() == 10 && (int)s.charAt(2) >= (int)'8') {
            // converting into decimal number
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < s.length(); i++) {    
                if (Character.isDigit(s.charAt(i))) {
                    if ((int)s.charAt(i) > (int)'5') {
                        sb.append((char)(2 * (int)'0' + 15 - (int)s.charAt(i)));
                    } else {
                        sb.append((char) ((int)'f' - ((int)s.charAt(i) - (int) '0')));
                    }
                } else {
                    sb.append((char)((int)'0' + (int)'f' - (int)s.charAt(i)));
                }
            }
            return -(Integer.parseInt(sb.toString(), 16) + 1);
        } else {
            return Integer.parseInt(s.substring(2), 16);
        }
    }

    public static int toInt(String s, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                sb.append((char)((int)s.charAt(i) - shift));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());    
    }

    public static String toAbc(int x, int shift) {
        StringBuilder sb = new StringBuilder();
        String s = Integer.toString(x);

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append((char)((int)s.charAt(i) + shift));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String args[]) {
        try {
            MyScanner in = new MyScanner(System.in);
            in.checker = (ch)-> Character.isDigit(ch) || ch == '-' ||
                                Character.isLetter(ch);

            ArrayList<IntVector> arr = new ArrayList<IntVector>();
            int shift = (int)'a' - (int)'0';
            String cur;

            try {
                int index = -1;
                while (!in.end()) {
                    arr.add(new IntVector());
                    index++;

                    while (in.hasNextInLine()) {
                        cur = in.next().toLowerCase();

                        if (isHex(cur)) {
                            arr.get(index).pushBack(hexToDec(cur, shift));
                        } else {
                            arr.get(index).pushBack(toInt(cur, shift));
                        }
                    }
                    in.nextLine();
                }

                for (int i = arr.size() - 2; i >= 0; i--) {
                    for (int j = arr.get(i).getLength() - 1; j >= 0; j--) {
                        System.out.print(toAbc(arr.get(i).get(j), shift) + " ");
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