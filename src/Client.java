import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost",8888);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));//receive
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);//send
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));//send
        String serverMessage, clientMessage;
        while (true) {
            // Read message from server
            if (input.ready()) {
                serverMessage = input.readLine();
                System.out.println("Server: " + serverMessage);
            }

            // Read message from client (user input)
            if (userInput.ready()) {
                clientMessage = userInput.readLine();
                output.println(clientMessage);
            }
        }
    }
}


