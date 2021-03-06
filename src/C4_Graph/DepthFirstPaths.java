package C4_Graph;

import java.util.Stack;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2020-03-01 15:35
 */
public class DepthFirstPaths {

    private boolean[] visited;
    /**
     * 从起点到一个顶点的已知路径上的最后一个顶点
     * */
    private int[] pathTo;
    private int start;

    public DepthFirstPaths(Graph graph, int start) {
        visited = new boolean[graph.getV()];
        pathTo = new int[graph.getV()];
        this.start = start;
    }

    private void dfs(Graph graph, int start) {
        visited[start] = true;
        for (int w : graph.adj(start)) {
            if (!visited[w]) {
                pathTo[w] = start;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public Iterable<Integer> getPathTo(int v) {
        if (!hasPathTo(v)) return null;
        else {
            Stack<Integer> stack = new Stack<>();
            for (int i = v; i != start; i = pathTo[i]) {
                stack.push(i);
            }
            stack.push(start);
            return stack;
        }
    }
}
