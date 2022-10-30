import java.io.*;
import java.util.*;
import java.lang.Comparable;


public class Wspp {
    public static void main(String[] args) {
        try {
            MyScanner in = new MyScanner(new File (args[0]));
            in.checker = (ch)->Character.isLetter(ch) || ch == '\'' ||
                    Character.getType(ch) == Character.DASH_PUNCTUATION;

            final Map<String, IntVector> wordStat = new LinkedHashMap<>();

            try {
                int counter = 0;
                while (in.hasNext()) {
                    final String s = in.next().toLowerCase();
                    counter++;

                    if (wordStat.containsKey(s)) {
                        IntVector temp = wordStat.get(s);
                        temp.set(0, temp.get(0) + 1);
                        temp.pushBack(counter);
                        wordStat.put(s, temp);
                    } else {
                        IntVector temp = new IntVector();
                        temp.pushBack(1);
                        temp.pushBack(counter);
                        wordStat.put(s, temp);
                    }
                }
            } finally {
                in.close();
            }

            final List<PairStringIntVec> pairs = new ArrayList<PairStringIntVec>();

            for (final Map.Entry<String, IntVector> entry : wordStat.entrySet()) {
                pairs.add(new PairStringIntVec(entry.getKey(), entry.getValue()));
            }

            final StringBuilder sb = new StringBuilder();
            for (int index = 0; index < pairs.size(); index++) {
                if (index != 0) {
                    sb.append('\n');
                }
                sb.append(pairs.get(index).getStr());
                sb.append(pairs.get(index).vecToString(0));
            }

            try (final BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(args[1]),
                            "utf8"
                    )
            )) {
                out.write(sb.toString());
            }

        } catch (final FileNotFoundException e) {
            System.out.println("Cannot find file: " + e.getMessage());
        } catch (final IOException e) {
            System.out.println("Cannot open file: " + e.getMessage());
        }
    }
}
