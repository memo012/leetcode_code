package com.adminsys.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-03-28 07-53
 **/

public class BioServiceSingle {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null; // 服务端对象
        Socket socket = null; // 客户端
        InputStream in = null; // 输入流
        OutputStream out = null; // 输出流
        try {
            serverSocket = new ServerSocket(port); // 指定端口 监听
            while (true){
                System.out.println("start");
                socket = serverSocket.accept(); // 阻塞  建立三次握手
                in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = in.read(buffer)) > 0){ // 阻塞
                    System.out.println("input is:"+new String(buffer, 0, length));
                    out = socket.getOutputStream();
                    out.write("success".getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}