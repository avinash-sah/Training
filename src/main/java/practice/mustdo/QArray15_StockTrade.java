package practice.mustdo;

import java.util.ArrayList;

public class QArray15_StockTrade {

    static class Interval{
        int buy;
        int sell;
    }

    public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int n = price.length;

        buySell(price, n);
    }

    private static void buySell(int[] pPrice, int pN) {
        if(pN == 1){
            return;
        }

        int count = 0;
        ArrayList<Interval> intervals = new ArrayList<>();

        int i = 0;
        while (i < pN -1){
            while (i < pN -1 && pPrice[i] >= pPrice[i + 1]){
                i++;
            }

            if(i == pN -1){
                return;
            }

            Interval interval = new Interval();
            interval.buy = i++;

            while (i < pN && pPrice[i] >= pPrice[i-1]){
                i++;
            }
            interval.sell = i -1 ;
            count++;
            intervals.add(interval);
        }

        if(count == 0){
            System.out.println("No purchase");;
        }else{
            for (int j = 0; j < count; j++) {
                System.out.println(intervals.get(j).buy + " " + intervals.get(j).sell);
            }
        }
    }
}
