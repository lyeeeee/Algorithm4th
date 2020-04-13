package C4_Graph;

import StdLib.In;
import StdLib.StdOut;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2020-04-13 11:22
 */
public class BreadFirstPaths {

    private boolean[] visited;

    private final int start;

    private int[] pathTo;

    private int[] distTo;

    public BreadFirstPaths(Graph g, int s) {
        this.start = s;
        pathTo = new int[g.getV()];
        visited = new boolean[g.getV()];
        distTo = new int[g.getV()];
        bfs(g,s);
    }

    private void bfs(Graph g, int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        distTo[start] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int tmp = q.remove();
            for (int w : g.adj(tmp)) {
                if (!visited[w]) {
                    pathTo[tmp] = w;
                    distTo[w] = distTo[tmp] + 1;
                    q.offer(w);
                    visited[w] = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return visited[v];
    }

    public int distTo(int v) {
        return distTo[v];
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

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadFirstPaths bfs = new BreadFirstPaths(G, s);

        for (int v = 0; v < G.getV(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.getPathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }
}
