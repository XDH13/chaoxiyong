package com.huawei.classroom.student.h15;

public class ThreadUtil extends Thread{
  private StringBuffer buf;

  public ThreadUtil() {
  }

  public ThreadUtil(StringBuffer buf) {
    this.buf = buf;
  }

  public StringBuffer getBuf() {
    return buf;
  }

  public void setBuf(StringBuffer buf) {
    this.buf = buf;
  }

  @Override
  public void run() {
    long time = System.currentTimeMillis();
    while(true){
      if(System.currentTimeMillis() - time >= 1000)
        break;
    }
    buf.append("ok");
  }
}
