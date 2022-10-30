import java.io.*;
import java.util.*;
import java.lang.Comparable;


public class WordStatCount {
    public static void main(final String[] args) {
        try {
            MyScanner in = new MyScanner(new File (args[0]));
            in.checker = (ch)->Character.isLetter(ch) || ch == '\'' ||
                    Character.getType(ch) == Character.DASH_PUNCTUATION;

            final Map<String, Integer> wordStat = new LinkedHashMap<>();

            try {
                while (in.hasNext()) {
                    final String s = in.next().toLowerCase();
                    wordStat.put(s, wordStat.getOrDefault(s, 0) + 1);
                }
            } finally {
                in.close();
            }

            final List<PairStringInt> pairs = new ArrayList<PairStringInt>();

            for (final Map.Entry<String, Integer> entry : wordStat.entrySet()) {
                pairs.add(new PairStringInt(entry.getKey(), entry.getValue()));
            }

            pairs.sort(Comparator.comparing(PairStringInt::getNum));

            final StringBuilder sb = new StringBuilder();
            for (int index = 0; index < pairs.size(); index++) {
                if (index != 0) {
                    sb.append('\n');
                }
                sb.append(pairs.get(index).getStr());
                sb.append(" ");
                sb.append(pairs.get(index).getNum());
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
