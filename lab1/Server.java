package AsmaAlrefaei2221251369;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asma
 */
public class Server {
    ServerSocket ssocket;

    public Server(int port) {
        try {
            ssocket = new ServerSocket(port);
            while(true){
                Socket csocket = ssocket.accept();
                System.err.println(csocket.getInetAddress());
                System.out.println(csocket.getPort());

                InputStream cIn = csocket.getInputStream();
                int bSize = cIn.read();
                byte buffer[] = new byte[bSize];
                cIn.read(buffer);
                System.out.println(new String(buffer));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Server s1 = new Server(5000);
        
    }
    
}
