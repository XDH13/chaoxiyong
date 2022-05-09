package com.huawei.classroom.student.h16;

public class MyServer {
	
		int port;
		public MyServer() {
			
		}
		public MyServer(int port) {
			this.port = port;
		}
		public void startListen(int port) {
			MyServerType s = new MyServerType(port);
			s.start();
		}
}
