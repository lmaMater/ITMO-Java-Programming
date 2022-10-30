import java.io.*;


interface Checker {
    public boolean check(char ch);
}


public class MyScanner {
    private final Reader in;
    private final int bufferSize = 256;
    private char[] buffer = new char[bufferSize];
    private final char endl = '\n'; // System.getProperty("line.separator");
    private int read;
    private int index;
    public Checker checker;

    public MyScanner (File filename) throws IOException, FileNotFoundException {
        in = new InputStreamReader(
                new FileInputStream(filename) , "utf-8");
        read = in.read(buffer);
        index = 0;
        checker = (ch)-> !Character.isWhitespace(ch);
    }

    public MyScanner (String s) throws IOException {
        in = new StringReader(s);
        read = in.read(buffer);
        index = 0;
        checker = (ch)-> !Character.isWhitespace(ch); // default
    }

    public MyScanner (InputStream inputStream) throws IOException {
        in = new InputStreamReader(inputStream);
        read = in.read(buffer);
        index = 0;
        checker = (ch)-> !Character.isWhitespace(ch); // default
    }

    public boolean end() {
        return read == -1;
    }

    public void close() throws IOException {
        in.close();
    }

    public void nextToken() throws IOException {
        while (!end()) {
            if (index == bufferSize) {
                buffer = new char[bufferSize];
                read = in.read(buffer);
                index = 0;
            }

            if (checker.check(buffer[index])) {
                return;
            }
            index++;
        }
    }

    public boolean hasNext() throws IOException {
        nextToken();
        if (end()) {
            return false;
        }

        return checker.check(buffer[index]);
    }

    public String next() throws IOException {
        StringBuilder sb = new StringBuilder();
        nextToken();

        while (!end()) {
            sb.append(buffer[index]);
            index++;
            if (index == bufferSize) {
                buffer = new char[bufferSize];
                read = in.read(buffer);
                index = 0;
            }

            if (end() || !checker.check(buffer[index])) {
                return sb.toString();
            }
        }
        return null;
    }

    public void nextTokenOrEndl() throws IOException {
        while (!end()) {
            if (index == bufferSize) {
                buffer = new char[bufferSize];
                read = in.read(buffer);
                index = 0;
            }
            if (checker.check(buffer[index]) || buffer[index] == endl) {
                return;
            }
            index++;
        }
    }

    public boolean hasNextInLine() throws IOException {
        nextTokenOrEndl();
        if (end()) {
            return false;
        }

        return checker.check(buffer[index]);
    }

    public void nextLine() throws IOException {
        while (!end()) {
            if (index == bufferSize) {
                buffer = new char[bufferSize];
                read = in.read(buffer);
                index = 0;
            }

            if (buffer[index] == endl) {
                index++;
                if (index >= bufferSize) {
                    buffer = new char[bufferSize];
                    read = in.read(buffer);
                    index = 0;
                }
                return;
            }
            index++;
        }
    }
}