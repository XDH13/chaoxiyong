package com.huawei.classroom.student.h16;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public	class MyServerType extends Thread{
		int port;
		public MyServerType() {
			
		}
		public MyServerType(int port) {
			this.port = port;
		}
		public static void close(Closeable inout) {
			if (inout != null) {
				try {
					inout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		@Override
		public void run() {
			ServerSocket server = null;
			Socket socket = null;
			InputStream in = null;
			OutputStream out = null;
			try {
				server = new ServerSocket(port);
				socket = server.accept();
				in = socket.getInputStream();
				out = socket.getOutputStream();
				byte[] data = new byte[4096];
				int readed = in.read(data);
				String s;
				while(readed != -1 && !(s = new String(data)).equals("bye\r\n")) {
				out.write(data,0,readed);
				out.flush();
				readed = in.read(data);
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				close(socket);
				close(server);
				close(in);
				close(out);
				
			}
		}
	}

