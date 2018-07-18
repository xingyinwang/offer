package ForKJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Cser_W on 2018/4/11.
 */
public class CountTask extends RecursiveTask<Integer>{
    private static final int ThRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= ThRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (end + start) >> 1;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }
    public static void main(String[] args){
        Long start = System.currentTimeMillis();
        CountTask task = new CountTask(1,10000);

        Future<Integer> result = new ForkJoinPool().submit(task);
        try {
            System.out.println(result.get());
            Long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int count = 0;
        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            count += i;
        }
        Long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }
}
