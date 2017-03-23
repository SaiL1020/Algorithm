import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by sail on 5/19/16.
 * windows queue
 */
public class Poj2823 { // TLE :D
    public int n, k;
    public int[] windows;
    public int[][] queue;
    public int[] front, rear;
    ArrayList<Integer> res;
    public static void main(String[] args) {
        try {
            new Poj2823().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        init();
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            windows[i] = Integer.parseInt(line[i]);
            solve(i, 0);
            solve(i, 1);
        }
        for (int j = 0; j < 2; j++) {
            for (int i = j; i < (n - k + 1) * 2; i += 2) {
                System.out.print(res.get(i));
                if (i < (n - k) * 2) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void init() {
        windows = new int[n];
        queue = new int[2][n];
        front = new int[2];
        rear = new int[2];
        res = new ArrayList<>();
    }

    public void solve(int pos, int type) {
        if (type == 0) {    // MIN
            while (front[type] != rear[type] &&
                    windows[queue[type][rear[type] - 1]] > windows[pos]) --rear[type];
        } else {    //MAX
            while (front[type] != rear[type] &&
                    windows[queue[type][rear[type] - 1]] < windows[pos]) --rear[type];
        }
        queue[type][rear[type]++] = pos;
        while (queue[type][front[type]] <= pos - k) ++front[type];
        if (pos >= k - 1) res.add(windows[queue[type][front[type]]]);
    }
}

/* use C++

#include <stdio.h>

#define N 1000010
int n, k;
int queue[2][N], res[2][N];
int windows[N], front[2], rear[2];
void solve(int pos, int type);
int main() {
    scanf("%d %d", &n, &k);
    for (int i = 0; i < n; i++) {
        scanf("%d", windows + i);
        solve(i, 0);
        solve(i, 1);
    }
    for (int j = 0; j < 2; j++) {
        for (int i = k - 1; i < n; i++) {
            printf("%d", res[j][i]);
            if (i < n - 1) printf(" ");
        }
        printf("\n");
    }
    return 0;
}

void solve(int pos, int type) {
    if (type == 0) {    // MIN
        while (front[type] != rear[type] &&
            windows[queue[type][rear[type] - 1]] > windows[pos]) --rear[type];
    } else {    //MAX
        while (front[type] != rear[type] &&
            windows[queue[type][rear[type] - 1]] < windows[pos]) --rear[type];
    }
    queue[type][rear[type]++] = pos;
    while (queue[type][front[type]] <= pos - k) ++front[type];
    res[type][pos] = windows[queue[type][front[type]]];
}

*/