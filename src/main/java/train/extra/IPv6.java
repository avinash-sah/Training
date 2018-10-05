package train.extra;

public class IPv6 {

    public static void main(String[] args) {
        int[] pulDecimal = {2000,
                1,
                0,
                0,
                40595,
                0,
                0,
                0};

        getMac(pulDecimal);
    }

    private static void getMac(int[] pulDecimal) {
        int ubIdx = 0;
        int ubIdy = 0;
        int ulStartIdx = 0;
        int ulCount = 0;
        int ulMaxCount = 0;

        for (ubIdx = 0; ubIdx < 8; ubIdx++) {
            if (pulDecimal[ubIdx] == 0) {


                for (ubIdy = ubIdx; ubIdy < 8; ubIdy++) {
                    if (pulDecimal[ubIdy] == 0) {
                        ulCount++;

                        if (ulMaxCount < ulCount) {
                            ulStartIdx = ubIdy - ulCount + 1;
                            ulMaxCount = ulCount;
                        }
                    }else{
                        break;
                    }
                }
                ulCount = 0;
                ubIdx = ubIdy;
            }
        }
        System.out.println(ulStartIdx + " "+ ulMaxCount);
    }
}
