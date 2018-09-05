package practice.mustdo.string;

public class QString_Roman {
    public static void main(String[] args) {
        String str = "MCMIV";
        System.out.println("Integer form of Roman Numeral" +
                " is " + romanToDecimal(str));
    }

    private static int romanToDecimal(String pStr) {
        int val = 0;
        for (int i = 0; i < pStr.length(); i++) {
            int val1 = value(pStr.charAt(i));
            if(i + 1 < pStr.length()){
                int val2 = value(pStr.charAt(i+1));
                if(val2 > val1){
                    val += val2-val1;
                    i++;
                }else{
                    val += val1;
                }
            }else{
                val+= val1;
            }
        }
        return val;
    }

    static int value(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
}
