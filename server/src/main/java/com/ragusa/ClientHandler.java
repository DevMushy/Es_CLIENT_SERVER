package com.ragusa;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{

    private Socket s;
    private static int x = 1;
    private int id;

    public ClientHandler(Socket s){
        this.s = s;
        id = x++;
    }

    public void run(){
        try {
            System.out.println("Client connesso");


            // per parlare
            PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
              
            // per ascoltare
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            System.out.println(br.readLine()); 
            pr.println("Ciao, come ti chiami?"); 
            String nome = br.readLine(); 
            System.out.println("Utente: " + nome);
            pr.println("benvenuto " + nome.toUpperCase() + " sei l'utente n: " + id); 
            
            System.out.println(br.readLine());
            
            s.close();
        
        } catch (Exception e) {
            System.out.println("CIAO");
        }
            
    }
    
}