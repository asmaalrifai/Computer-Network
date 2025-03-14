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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    ServerSocket ssocket;

    public void Start(int port) {
        try {
            this.ssocket = new ServerSocket(port);
            while (!this.ssocket.isClosed()) {
                Socket csocket = this.ssocket.accept(); // blocking
                OutputStream cout = csocket.getOutputStream();
                InputStream cinput = csocket.getInputStream();

                // Read message
                int bsize = cinput.read();
                byte buffer[] = new byte[bsize];
                cinput.read(buffer);

                // Operation
                String rqMsg = new String(buffer);
                String tokens[] = rqMsg.split("#");

                int num1 = Integer.parseInt(tokens[0].trim());
                int num2 = Integer.parseInt(tokens[2].trim());
                char operator = tokens[1].charAt(0);

                String rsMsg = " ";

                switch (operator) {
                    case '+':
                        rsMsg = " " + (num1 + num2);
                        break;
                    case '-':
                        rsMsg = " " + (num1 - num2);
                        break;
                    case '*':  
                        rsMsg = " " + (num1 * num2);
                        break;
                    case '/':  
                        if (num2 != 0) {
                            rsMsg = " " + (num1 / num2);
                        } else {
                            rsMsg = " ERROR: Division by zero!";
                        }
                        break;
                    default:
                        rsMsg = " ERROR: Invalid operator!";
                }

                
                cout.write(rsMsg.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Server s1 = new Server();
        s1.Start(6000);
    }
}


