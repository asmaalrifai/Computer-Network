/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UpperCase;

/**
 *
 * @author asma
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket csocket;
    OutputStream coutput;
    InputStream cinput;

    public void Connect(String ip, int port) throws IOException {
        this.csocket = new Socket(ip, port);
        this.coutput = csocket.getOutputStream();
        this.cinput = csocket.getInputStream();
    }

    public void SendMsg(String msg) throws IOException {
        this.coutput.write(msg.getBytes());
    }

    public String ReadMsg() throws IOException {
        int bsize = this.cinput.read();
        byte buffer[] = new byte[bsize];
        this.cinput.read(buffer);
        String rsMsg = new String(buffer);
        return rsMsg;
    }
}
