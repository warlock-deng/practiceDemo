package tree;

/**
 * @author Warlock.deng
 * Created at 2019-09-26
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);


}
