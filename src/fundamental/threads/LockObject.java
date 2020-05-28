package fundamental.threads;

public class LockObject {

    int orderNum = 0;
    static final int MAX_NUM = 100;

    public LockObject(int orderNum) {
        this.orderNum = orderNum;
    }
}
