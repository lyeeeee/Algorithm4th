package C4_Graph;

/**
 * @program: Algorithm4th
 * @description: ${description}
 * @author: liyi
 * @create: 2020-04-13 11:49
 */
public class CC {
    private boolean[] visited;

    /**
     * 连通图的id
     * */
    private int[] ids;

    /**
     * 连通图的数量
     * */
    private int count;

    public CC(Graph g) {
        visited = new boolean[g.getV()];
        ids = new int[g.getV()];
        for (int v = 0; v < g.getV(); ++v) {
            if (!visited[v]) {
                dfs(g,v);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        ids[v] = count;
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(g, w);
            }
        }
    }

    public int id(int v) {
        return ids[v];
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        return id(v) == id(w);
    }
}
