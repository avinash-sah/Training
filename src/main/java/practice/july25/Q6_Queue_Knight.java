package practice.july25;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_Queue_Knight {
    public static void main(String[] args) {
        int N = 20;
        int knightPos[] = {5, 7};
        int targetPos[] = {15, 20};
        int res = findMinPath(knightPos, targetPos, N);
        System.out.println(res);
    }

    private static int findMinPath(int[] pKnightPos, int[] pTargetPos, int pN) {

        int dx[] = {-1, 1, 2, 2, 1, -1, -2, -2};
        int dy[] = {2, 2, 1, -1, -2, -2, -1, 1};

        boolean[][] visited = new boolean[pN + 1][pN + 1];
        for (int i = 1; i <= pN; i++) {
            for (int j = 1; j <= pN; j++) {
                visited[i][j] = false;
            }
        }

        Queue<Cell> cells = new LinkedList<>();
        cells.add(new Cell(pKnightPos[0], pKnightPos[1], 0));

        Cell cell;
        int x, y;
        while (!cells.isEmpty()) {
            cell = cells.poll();
            if (cell.x == pTargetPos[0] && cell.y == pTargetPos[1]) {
                return cell.depth;
            }
            for (int i = 0; i < dx.length; i++) {
                x = cell.x + dx[i];
                y = cell.y + dy[i];
                if (isInside(x, y, pN) && !visited[x][y]) {
                    visited[x][y] = true;
                    cells.add(new Cell(x, y, cell.depth + 1));
                }
            }
        }

        return -1;

    }

    static boolean isInside(int x, int y, int pN) {
        return x >= 1 && x <= pN
                && y >= 1 && y <= pN;
    }

    static class Cell {
        int x, y;
        int depth;

        public Cell(int pX, int pY, int pDepth) {
            x = pX;
            y = pY;
            depth = pDepth;
        }
    }
}
