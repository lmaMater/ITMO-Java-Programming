import java.io.*;
import java.util.*;
import java.lang.Comparable;


public class WsppSortedSecondG {
    public static void main(String[] args) {
        try {
            MyScanner in = new MyScanner(new File (args[0]));
            in.checker = ch -> Character.isLetter(ch) || ch == '\'' ||
                    Character.getType(ch) == Character.DASH_PUNCTUATION;

            final Map<String, WordInfo> wordStat = new LinkedHashMap<>();

            try {
                int curString = 0;
                int counter = 0;

                while (!in.end()) {
                    curString++;

                    while (in.hasNextInLine()) {
                        final String s = in.next().toLowerCase();
                        counter++;
                        WordInfo curInfo;

                        if (wordStat.containsKey(s)) {
                            curInfo = wordStat.get(s);
                            curInfo.counter++;
                            if (curInfo.curString != curString) {
                                curInfo.curString = curString;
                                curInfo.curStringCounter = 1;
                            } else {
                                curInfo.curStringCounter++;
                            }
                        } else {
                            curInfo = new WordInfo(1, curString, 1);
                            wordStat.put(s, curInfo);
                        }

                        if (curInfo.curStringCounter % 2 == 0) {
                              curInfo.indexes.pushBack(counter);
                        }
                        
                        wordStat.put(s, curInfo);
                    }
                    in.nextLine();
                }
            } finally {
                in.close();
            }

            final List<PairStringWordInfo> pairs = new ArrayList<PairStringWordInfo>();

            for (final Map.Entry<String, WordInfo> entry : wordStat.entrySet()) {
                pairs.add(new PairStringWordInfo(entry.getKey(), entry.getValue()));
            }

            pairs.sort(Comparator.comparing(PairStringWordInfo::getStr));

            final StringBuilder sb = new StringBuilder();
            for (int index = 0; index < pairs.size(); index++) {
                if (index != 0) {
                    sb.append('\n');
                }
                sb.append(pairs.get(index).getStr());
                pairs.get(index).getInfo().printInfo(sb);
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
