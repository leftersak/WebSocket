package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String argv[]) throws Exception 
        { 
            String sentence; 
            String sentenceClient; 

            BufferedReader inFromUser = 
            new BufferedReader(new InputStreamReader(System.in)); 

            Socket clientSocket = new Socket("localhost", 12000); 

            DataOutputStream outToServer = 
            new DataOutputStream(clientSocket.getOutputStream()); 
            BufferedReader inFromServer = 
            new BufferedReader(new
            InputStreamReader(clientSocket.getInputStream())); 
			while (true){
				sentence = inFromUser.readLine();
				outToServer.writeBytes(sentence + '\n'); 
		
				sentenceClient = inFromServer.readLine(); 
				if (sentenceClient.equals("stop")){
					System.out.println("Closing connection to the server...");
					break;
				}
		
				System.out.println("FROM SERVER: " + sentenceClient); 
				
				if (sentenceClient.equalsIgnoreCase("Goodbye!") || sentenceClient.contains("Server stopped")) {
					break;
				}
			}
          
          	clientSocket.close(); 
                     
      	} 
  
}
