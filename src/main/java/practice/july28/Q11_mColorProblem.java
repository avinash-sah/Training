package practice.july28;

public class Q11_mColorProblem {
    int V;

    public Q11_mColorProblem(int pV) {
        V = pV;
    }

    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int m = 3; // Number of colors

        Q11_mColorProblem problem = new Q11_mColorProblem(4);
        problem.color(graph, m);
    }

    private void color(int[][] pGraph, int pM) {
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }
        if (colorUtil(pGraph, color, pM, 0)) {
            printSol(color);
        } else {
            System.out.println("No solution");
        }
    }

    boolean isSafe(int[][] graph, int[] color, int index, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[i][index] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    private void printSol(int[] pColor) {
        for (int i = 0; i < V; i++) {
            System.out.print(pColor[i] + " ");
        }
        System.out.println();
    }

    private boolean colorUtil(int[][] pGraph, int[] pColor, int pM, int pV) {

        if(pV == V){
            return true;
        }

        for (int i = 1; i <= pM; i++) {
           if(isSafe(pGraph, pColor, pV, i)){
               pColor[pV] = i;
               if(colorUtil(pGraph, pColor, pM, pV +1)){
                   return true;
               }
               pColor[pV] = 0;
           }
        }
        return false;
    }
}
