package practice.mustdo.stackQ;

public class Qq_CircularTour {

    public static void main(String[] args) {
        Pump[] arr = {new Pump(6, 4),
                new Pump(3, 6),
                new Pump(7, 3)};

        int start = printTour(arr);

        System.out.println(start == -1 ? "No Solution" : "Start = " + start);
    }

    private static int printTour(Pump[] pArr) {
        int n = pArr.length;
        int start = 0;
        int end = 1;
        int curr = pArr[start].petrol - pArr[start].distance;

        while (start != end || curr < 0) {

            while (start != end && curr < 0) {
                curr -= pArr[start].petrol - pArr[start].distance;
                start = (start + 1) % n;

                if (start == 0) {
                    return -1;
                }
            }

            curr += pArr[end].petrol - pArr[end].distance;
            end = (end + 1) % n;
        }

        return start;
    }

    static class Pump {
        int petrol;
        int distance;

        public Pump(int pPetrol, int pDistance) {
            petrol = pPetrol;
            distance = pDistance;
        }
    }
}
