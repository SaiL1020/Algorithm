package google;

import java.util.Arrays;

/**
 * author:      SaiL1020
 * time:        4/13/17 10:54 PM
 * project:     Algorithm
 */
public class Maze {
    static int[][] path;
    static int[][] visited;
    static int[][] isAfterDownWall;
    static int W, H;
    static int isDownWall; // 1: one wall has been destroyed. 0: not yet
    static int[] dir = {0, 1, 1, 0, 0, -1, -1, 0}; // right, down, left, up

    // find the length of the shortest path
    // at most one wall can be destroyed
    // TODO: need fix bug by comparing Maze.java(dfs) and Maze2.java(bfs)
    public static int answer(int[][] maze) {
        H = maze.length;
        assert (H > 0);
        W = maze[0].length;
        assert (W > 0);

        path = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(path[i], Integer.MAX_VALUE);
        }
        visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(visited[i], 0);
        }
        isAfterDownWall = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(isAfterDownWall[i], 0);
        }
        isDownWall = 0;

        dfs(maze, 0, 0, 1);
        return path[H - 1][W - 1];
    }
    public static void dfs(int[][] maze, int x, int y, int step) {
        if (path[x][y] < step) return;
        if (path[x][y] == step) {
            if (isAfterDownWall[x][y] == 0 || isDownWall == 1)
                return;
        }
        path[x][y] = step;
        visited[x][y] = 1;
        if (isDownWall == 1) isAfterDownWall[x][y] = 1;
        else isAfterDownWall[x][y] = 0;
        for (int d = 0; d < 8; d += 2) {
            int nx = x + dir[d];
            int ny = y + dir[d + 1];
            if (isInside(nx, ny) && visited[nx][ny] == 0) {
                if (maze[nx][ny] == 0) {
                    // System.out.println("$$ " + step + ": " + nx + " " + ny);
                    dfs(maze, nx, ny, step + 1);
                } else {
                    if (isDownWall == 0) {
                        isDownWall = 1;
                        // System.out.println("++ " + step + ": " + nx + " " + ny);
                        dfs(maze, nx, ny, step + 1);
                        isDownWall = 0;
                    }
                }
            }
        }
        visited[x][y] = 0;
    }
    public static boolean isInside(int x, int y) {
        return 0 <= x && x < H && 0 <= y && y < W;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0,1,1,0},
                {0,0,0,1},
                {1,1,0,0},
                {1,1,1,0}
        }; // 7
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
//        int[][] maze = new int[40][40];
//        for (int i = 0; i < 40; i++) {
//            Arrays.fill(maze[i], 0);
//        } // 79
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
