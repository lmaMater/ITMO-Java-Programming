import java.math.BigInteger;


public class SumBigIntegerHex {
    public static boolean isHex(String s) {
        return s.startsWith("0x");
    }

    public static BigInteger newResult(String arg, BigInteger result) {
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
                
                if (isHex(currentNum)) {
                    result = result.add(new BigInteger(currentNum.substring(2), 16));
                } else {
                    result = result.add(new BigInteger(currentNum));    
                }

            } else {
                i++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        BigInteger result = BigInteger.ZERO;

        for (String arg : args) {
            result = newResult(arg, result);
        }

        System.out.println(result);
    }
}