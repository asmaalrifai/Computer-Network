package AsmaAlrefaei2221251369;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asma
 */
public class Client {
    Socket cSocket;
    public void connect(String ip, int port){
        try {
            cSocket = new Socket(ip,port);
            OutputStream cOut = cSocket.getOutputStream();                
            cOut.write(" message".getBytes());
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Client c1 = new Client();
        c1.connect("172.31.1.47", 5000);  
    }
}
