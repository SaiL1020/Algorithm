package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author:      SaiL1020
 * time:        4/14/17 12:36 AM
 * project:     Algorithm
 */
public class Maze2 {
    static int[][] path;
    static int W, H;
    static int[] dir = {0, 1, 1, 0, 0, -1, -1, 0}; // right, down, left, up
    static int minLength;
    // find the length of the shortest path
    // at most one wall can be destroyed
    public static int answer(int[][] maze) {
        H = maze.length;
        assert (H > 0);
        W = maze[0].length;
        assert (W > 0);

        minLength = H * W;
        path = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // try to assign each wall to passable
                if (maze[i][j] == 1) {
                    maze[i][j] = 0;
                    for (int k = 0; k < H; k++) {
                        Arrays.fill(path[k], 0);
                    }
                    bfs(maze);
                    maze[i][j] = 1;
                }
            }
        }
        // case: no wall
        if (minLength == H * W) {
            bfs(maze);
        }
        return minLength;
    }
    public static void bfs(int[][] maze) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        path[0][0] = 1;
        int step = 1;
        OUTER:
        while (!queue.isEmpty()) {
            ++step;
            //System.out.println("step: " + step);
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int pos = queue.poll();
                int x = pos / W;
                int y = pos % W;
                for (int d = 0; d < 8; d += 2) {
                    int nx = x + dir[d];
                    int ny = y + dir[d + 1];
                    if (isInside(nx, ny) && path[nx][ny] == 0 && maze[nx][ny] == 0) {
                        path[nx][ny] = step;
                        if (nx == H - 1 && ny == W - 1) {
                            break OUTER;
                        }
                        queue.add(nx * W + ny);
                    }
                }
            }
        }
        if (path[H - 1][W - 1] != 0)
            minLength = Math.min(minLength, path[H - 1][W - 1]);
    }
    public static boolean isInside(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }

    public static void main(String[] args) {
//        int[][] maze = {
//                {0,1},
//                {0,0}
//        }; // 3
//        int[][] maze = {
//                {0,1,1,0},
//                {0,0,0,1},
//                {1,1,0,0},
//                {1,1,1,0}
//        }; // 7
//        int[][] maze = {
//                {0,1,1,0,0,0,0},
//                {0,0,1,1,1,0,1},
//                {1,0,0,0,1,0,1},
//                {1,1,1,1,1,0,0}
//        }; // 10
//        int[][] maze = {
//                {0,0,0,0,0,0},
//                {1,1,1,1,1,0},
//                {0,0,0,0,0,0},
//                {0,1,1,1,1,1},
//                {0,1,1,1,1,1},
//                {0,0,0,0,0,0}
//        }; // 11
//        int[][] maze = {
//                {0,0,0,0,0,0},
//                {1,1,1,1,1,0},
//                {1,0,0,0,0,0},
//                {0,1,1,1,0,1},
//                {0,1,1,1,1,1},
//                {0,0,0,0,0,0}
//        }; // 13
//        int[][] maze = {
//                {0,0,0,0},
//                {0,1,1,0},
//                {1,1,0,0},
//                {1,1,0,1},
//                {1,1,1,1},
//                {1,0,0,0}
//        }; // 11
        int[][] maze = new int[40][40];
        for (int i = 0; i < 40; i++) {
            Arrays.fill(maze[i], 0);
        } // 79
//        maze[20][20] = 1;
//        int[][] maze;
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt(), n = in.nextInt();
//        maze = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                maze[i][j] = in.nextInt();
//            }
//        }
        System.out.println(answer(maze));
    }

}
