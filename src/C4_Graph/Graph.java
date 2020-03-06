package C4_Graph;

import C1_Foundmental.Bag;
import StdLib.In;
import StdLib.StdOut;

/**
 * @program: Algorithm4th
 * @description: 使用邻接表的方法表示一张图
 * 所需空间 E+V
 * 性能：
 * 添加一条边  1
 * 检查两个顶点w,v是否相邻  degree(v)
 * 遍历一个顶点的相邻顶点   degree(v)
 * @author: liyi
 * @create: 2020-03-01 14:37
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adjcent;

    public Graph(int V) {
        this.V = V;
        adjcent = new Bag[V];
        for (int i = 0;i < V; ++i) {
            adjcent[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int edges = in.readInt();
        for (int i = 0;i < edges; ++i) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v, int w) {
        adjcent[v].add(w);
        adjcent[w].add(v);
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adjcent[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adjcent[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }
}
