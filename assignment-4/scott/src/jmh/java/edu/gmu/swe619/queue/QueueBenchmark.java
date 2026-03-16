package edu.gmu.swe619.queue;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class QueueBenchmark {

    private static final int OPERATIONS = 1000;

    @Benchmark
    public void benchmarkImmutableQueue() {
        ImmutableQueue<Integer> q = new ImmutableQueue<>();
        for (int i = 0; i < OPERATIONS; i++) {
            q = q.enQueue(i);
        }
        for (int i = 0; i < OPERATIONS; i++) {
            q.getFirst();
            q = q.deQueue();
        }
    }

    @Benchmark
    public void benchmarkTwoStackImmutableQueue() {
        TwoStackImmutableQueue<Integer> q = new TwoStackImmutableQueue<>();
        for (int i = 0; i < OPERATIONS; i++) {
            q = q.enQueue(i);
        }
        for (int i = 0; i < OPERATIONS; i++) {
            q.getFirst();
            q = q.deQueue();
        }
    }
}
