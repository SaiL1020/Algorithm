/**
 * Created by sail on 4/30/16.
 */
public class DeleteNonLeafLTHalf {
    int sum;
    int[][] graph;

    public static void main(String[] args) {
        new DeleteNonLeafLTHalf().run();
    }

    public void run() {
        sum = 10;
        graph = new int[sum][sum];
        addEdge(1,2);
        addEdge(1,3);
        addEdge(2,4);
        addEdge(2,5);
        addEdge(6,3);
        addEdge(7,3);
    }

    public void addEdge(int i, int j) {
        graph[i][j] = graph[j][i] = 1;
    }
}
