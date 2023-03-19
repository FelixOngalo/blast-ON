import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888); // connect to server on localhost:8888
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            
            String message = "";
            while (!message.equals("exit")) {
                message = consoleInput.readLine(); // read message from console
                output.println(message); // send message to server
                String response = input.readLine(); // read response from server
                System.out.println("Server says: " + response);
            }
            
            socket.close(); // close the connection
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
