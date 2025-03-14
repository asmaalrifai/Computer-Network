/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculator;

/**
 *
 * @author Asma
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

    public void SendParameters(int num1, String opr, int num2) throws IOException {
        String rqMsg = " " + num1 + "#" + opr + "#" + num2;
        this.coutput.write(rqMsg.getBytes());
    }

    public int GetResult() throws IOException {
        int bsize = this.cinput.read();
        byte buffer[] = new byte[bsize];
        this.cinput.read(buffer);
        String rsMsg = new String(buffer);
        int result = Integer.parseInt(rsMsg.trim());
        return result;
    }
}

