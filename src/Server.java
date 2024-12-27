import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Server started");
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server is waiting for connection");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));//receive
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);//send
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));//send
        String clientMessage, serverMessage;

        while (true) {
            // Read message from client
            if (input.ready()) {
                clientMessage = input.readLine();
                System.out.println("Client: " + clientMessage);
            }

            // Read message from server (user input)
            if (userInput.ready()) {
                serverMessage = userInput.readLine();
                output.println(serverMessage);
            }
        }
    }
}
