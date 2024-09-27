package socket;

import java.io.*; 
import java.net.*; 

class TCPServer { 

  public static void main(String argv[]) throws Exception 
    { 
      String clientSentence; 
      String sentenceServer; 

      ServerSocket welcomeSocket = new ServerSocket(12000); 
  
      while(true) { 
  
            Socket connectionSocket = welcomeSocket.accept(); 
            System.out.println("Client connected!");

           BufferedReader inFromClient = 
              new BufferedReader(new
              InputStreamReader(connectionSocket.getInputStream()));
          DataOutputStream  outToClient = 
             new DataOutputStream(connectionSocket.getOutputStream()); 

           while(true){
              clientSentence = inFromClient.readLine(); 
              if (clientSentence.equals("stop")){
                System.out.println("Client disconnected.");
                break;
              }
              System.out.println("FROM CLIENT: " + clientSentence);

              BufferedReader inFromServer = 
              new BufferedReader(new InputStreamReader(System.in)); 
              sentenceServer = inFromServer.readLine();

              outToClient.writeBytes(sentenceServer + "\n"); 
           }

            
        } 
    } 
} 
