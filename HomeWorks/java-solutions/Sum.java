public class Sum {
    public static int newResult(String arg, int result) {
        int i = 0;

        while (i < arg.length()) {
            if (!Character.isWhitespace(arg.charAt(i))) {
                int beginIndex = i;
                i++;

                while (i < arg.length()){
                    if (Character.isWhitespace(arg.charAt(i))) {
                        break;
                    }
                    i++;
                }

                int endIndex = i;
                String currentNum = arg.substring(beginIndex, endIndex).toLowerCase();
                result += Integer.parseInt(currentNum);    
            } else {
                i++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int sum = 0;
        for (String arg: args) {
            sum = newResult(arg, sum);
        }
        System.out.print(sum);
    }
}