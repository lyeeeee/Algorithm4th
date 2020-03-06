package C4_Graph;

import StdLib.In;
import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description:
 * 标记同起点连通的所有顶点的时间复杂度，和顶点的度数之和成正比，每个顶点都只会被访问一次，保证了时间上限
 * @author: liyi
 * @create: 2020-03-01 15:24
 */
public class DepthFirstSearch {
    private boolean[] visited;
    private int count;

    public DepthFirstSearch(Graph g, int start) {
        visited = new boolean[g.getV()];
        count = 0;
        dfs(g, start);
    }

    private void dfs(Graph g, int start) {
        visited[start] = true;
        count++;
        for (int w : g.adj(start)) {
            if (!visited[w]) {
                dfs(g, w);
            }
        }
    }

    private int count() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        for (int v = 0; v < G.getV(); v++) {
            if (search.visited[v])
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.getV())
            StdOut.println("NOT connected");
        else
            StdOut.println("connected");
    }
}
