package practice.mustdo.stackQ;

import java.util.LinkedList;
import java.util.Queue;

public class Qq_RottenOranges {
    public static void main(String[] args) {
        int arr[][] = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges(arr, 3, 5);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }

    private static int rotOranges(int[][] pArr, int R, int C) {
        Queue<Cell> cells = new LinkedList<>();
        int frames = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pArr[i][j] == 2) {
                    cells.add(new Cell(i, j));
                }
            }
        }
        cells.add(new Cell(-1, -1));

        while (!cells.isEmpty()) {
            boolean flag = false;
            while (cells.peek() != null && !cells.peek().isDel()) {
                Cell temp = cells.peek();

                if (isValid(temp.x + 1, temp.y, R, C) && pArr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        flag = true;
                        frames++;
                    }
                    pArr[temp.x + 1][temp.y] = 2;
                    cells.add(new Cell(temp.x + 1, temp.y));
                }
                if (isValid(temp.x - 1, temp.y, R, C) && pArr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        flag = true;
                        frames++;
                    }
                    pArr[temp.x - 1][temp.y] = 2;
                    cells.add(new Cell(temp.x - 1, temp.y));
                }
                if (isValid(temp.x, temp.y + 1, R, C) && pArr[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        flag = true;
                        frames++;
                    }
                    pArr[temp.x][temp.y + 1] = 2;
                    cells.add(new Cell(temp.x, temp.y + 1));
                }
                if (isValid(temp.x, temp.y - 1, R, C) && pArr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        flag = true;
                        frames++;
                    }
                    pArr[temp.x][temp.y - 1] = 2;
                    cells.add(new Cell(temp.x, temp.y - 1));
                }

                cells.remove();
            }
            cells.remove();
            if (!cells.isEmpty()) {
                cells.add(new Cell(-1, -1));
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pArr[i][j] == 1) {
                    return -1;
                }
            }
        }
        return frames;

    }

    // function to check whether a cell is valid / invalid
    static boolean isValid(int i, int j, int R, int C) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }


    static class Cell {
        int x;
        int y;

        public Cell(int pX, int pY) {
            x = pX;
            y = pY;
        }

        boolean isDel() {
            return x == -1 && y == -1;
        }
    }
}
