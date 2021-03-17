package thread;

/**
 * @author warlock.deng
 * Created at 2020/5/25
 */
public class AlternatePrint {

    private int n;

    public AlternatePrint(int n) {
        this.n = n;
    }

    volatile boolean permitFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(permitFoo) {
                printFoo.run();
                i++;
                System.out.println(i);
                permitFoo = false;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(!permitFoo) {
                printBar.run();
                i++;
                System.out.println(i);
                permitFoo = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        AlternatePrint alternatePrint = new AlternatePrint(90);

        Thread one = new Thread();

        alternatePrint.foo(one);

        Thread two = new Thread();
        alternatePrint.bar(two);

    }

}
