package tree;

/**
 * 并查集（由孩子指向父亲的树结构，用来解决连接问题）
 * 可以很快判断网络（不仅仅是互联网，还包括用户之间形成的网络）节点中的连接状态
 * 连接问题和路径问题
 *
 * @author Warlock.deng
 * Created at 2019-09-26
 */
public class UnionFindDemo implements UF {

    private int[] id;

    public UnionFindDemo(int size) {
        this.id = new int[size];
        for (int i = 0; i < size; i++) {
            this.id[i] = i;
        }
    }

    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

    }
}
