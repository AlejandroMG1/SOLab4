package Models;

public class Semaphore {
    private int buffer;
    private int used;
    private int inQueue;

    public Semaphore(int buffer) {
        this.buffer = buffer;
        this.used = 0;
        this.inQueue = 0;
    }

    public int getBuffer() {
        return buffer;
    }

    public int getUsed() {
        return used;
    }

    public int getInQueue() {
        return inQueue;
    }

    public int useBuffer(int use) {
        if (use <= buffer - used) {
            used += use;
        } else {
            inQueue = used + use - buffer;
            used = buffer;
        }
        return used;
    }

    public int freeBuffer(int free) {
        if (inQueue > 0 & inQueue >= free) {
            inQueue = inQueue - free;
        } else if (inQueue > 0) {
            used = used + inQueue - free;
            inQueue = 0;
        } else {
            used = used - free;
        }
        return used;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
        this.used = 0;
        this.inQueue = 0;
    }
}
