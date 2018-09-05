package practice.mustdo.string;

public class QString_RotatedBy2 {
    public static void main(String[] args) {

        String str1 = "geeks";
        String str2 = "ksgee";

        System.out.println(isRotated(str1, str2));
    }

    private static boolean isRotated(String pStr1, String pStr2) {
        if (pStr1.length() != pStr2.length()) {
            return false;
        }

        String anticlock = pStr1.substring(2) + pStr1.substring(0, 2);
        String clock =  pStr1.substring(pStr1.length() - 2) + pStr1.substring(0, pStr1.length() - 2) ;
        return anticlock.equals(pStr2) || clock.equals(pStr2);
    }
}
