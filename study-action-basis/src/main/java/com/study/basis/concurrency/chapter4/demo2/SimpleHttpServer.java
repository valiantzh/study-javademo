package com.study.basis.concurrency.chapter4.demo2;

import sun.nio.ch.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author valiantzh
 * @version 1.0
 */
public class SimpleHttpServer {
    //static ThreadPool<HttpRequestHandler> threadPool
    static String basePath;
    static ServerSocket serverSocket;

    static int port = 8080;

    static class HttpRequestHandler implements Runnable{
        private Socket socket;

        public HttpRequestHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;

            PrintWriter out = null;
            InputStream in = null;

            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();

                //
                String filePath = basePath + header.split(" ")[1];

                out.flush();
            } catch (Exception ex){
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, reader, out, in);
            }
        }
        private static void close(Closeable... closeables){
            if(closeables != null){
                for(Closeable closeable: closeables){
                    try {
                        closeable.close();
                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                }
            }
        }
    }
}
