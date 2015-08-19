/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel.numbers;

/**
 *
 * @author kmhasan
 */
public class NumberSumRunnable implements Runnable {
    private long from;
    private long to;
    private long result;
    private Thread thread;
    
    public NumberSumRunnable(long from, long to) {
        this.from = from;
        this.to = to;
        thread = new Thread(this);
        thread.start();
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public long getResult() {
        return result;
    }
    
    private void doSum() {
        result = 0;
        for (long i = from; i <= to; i++)
            result = result + i;
    }
    
    @Override
    public void run() {
        doSum();
    }

    public Thread getThread() {
        return thread;
    }
}
