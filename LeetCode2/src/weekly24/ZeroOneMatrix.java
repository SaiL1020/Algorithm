package weekly24;

import java.util.*;

/**
 * @author sail
 * time 3/18/17 10:35 PM
 * project Algorithm
 */
public class ZeroOneMatrix {
    int m, n;
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        m = matrix.size();
        n = matrix.get(0).size();
        int[] xx = {1,-1,0,0};
        int[] yy = {0,0,1,-1};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix.get(i).get(j) == 0) {
                    vis[i][j] = true;
                    que.add(new int[]{i, j});
                }
        int dis = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; k++) {
                int[] p = que.poll();
                matrix.get(p[0]).set(p[1], dis);
                for (int ki = 0; ki < 4; ki++) {
                    int nx = p[0] + xx[ki];
                    int ny = p[1] + yy[ki];
                    if (inside(nx, ny) && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        que.add(new int[]{nx, ny});
                    }
                }
            }
            dis++;
        }
        return matrix;
    }
    private boolean inside(int x, int y) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    private void run() {
        //TODO convert int[][] to List<List<>>
        //matrix = Arrays.stream(input).flatMap(Arrays::stream).collect(Collectors.toList());

        List<List<Integer>> matrix = new LinkedList<>();
        String[] line = new Scanner(System.in).nextLine().split(",");
        for (String s : line) {
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(s));
            matrix.add(list);
        }

        // test time
        // LESSON: the complexity does not LIE, and go back checking your BAD code
        long time = System.currentTimeMillis();
        System.out.println(updateMatrix(matrix));
        System.out.println(System.currentTimeMillis() - time);
    }
    public static void main(String[] args) {
        new ZeroOneMatrix().run();
    }
}
