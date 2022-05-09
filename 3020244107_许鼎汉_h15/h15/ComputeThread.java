package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ComputeThread implements Callable<List<Long>> {
    private long[] cache = {2,3,5,7,11,13,17,19,23,29};
    private final int cache_len = 10;
    private final long cache_limit = 29;
    private final long cache_next = 31;
    private long start;
    private long end;

    public ComputeThread() {
    }

    public ComputeThread(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Long> call() throws Exception {
        List<Long> result = new ArrayList<>();
        outer:for(long i = start;i < end;i++){
            for(int j = 0;j < cache_len;j++)
                if(i % cache[j] == 0)
                    continue outer;
            if(cache_limit * cache_limit >= i)
                continue;
            for(long j = cache_next; j*j <=i;j+=2){
                if(i%j == 0)
                    continue outer;
            }
            result.add(i);
        }
        return result;
    }
}
