package in.algorithms.graphfind;

public class QuickFind {
    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFind qf = new QuickFind(10);
        qf.union(4, 3);
        qf.union(3, 8);
        qf.union(6, 5);
        System.out.println("4 and 8 connected: " + qf.connected(4, 8));
        System.out.println("4 and 5 connected: " + qf.connected(4, 5));
    }
}
