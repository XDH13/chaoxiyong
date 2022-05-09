package com.huawei.classroom.student.h15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class PrimeUtil {


  public List<Long> getPrimeList(long start, long end, int threadCount) throws ExecutionException, InterruptedException {
    long interval = (end - start)/threadCount;
    ExecutorService pool = Executors.newFixedThreadPool(threadCount);
    FutureTask[] tasks = new FutureTask[threadCount];
    for(int i = 0;i < threadCount;i++){
      FutureTask<List<Long>> task = new FutureTask<>(new ComputeThread(start, start + interval));
      tasks[i] = task;
      start += interval;
      pool.submit(task);
    }
    List<Long> primeList = new ArrayList<>();
    for(FutureTask<List<Long>> task : tasks)
      primeList.addAll(task.get());
    pool.shutdown();
    return primeList;
  }
}
