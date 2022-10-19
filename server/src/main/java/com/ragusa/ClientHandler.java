package com.ragusa;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;

public class ClientHandler extends Thread{

    private Socket s;
    private static int x = 1;
    private int id;
    private LocalDate date;
    private LocalTime time;
    
    public ClientHandler(Socket s){
        this.s = s;
        id = x++;
        setName("serverSgravoz");
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
            pr.println("benvenuto " + nome.toUpperCase() + " sei l'utente n: " + id + "comandi disponibili: ora,nome,data,id,fine"); 

            boolean StartStop = true;
            
            while(StartStop){
                String scelta = br.readLine();
                switch(scelta){

                    case ("data") :
                        date = LocalDate.now();
                        pr.println("data: " + date);
                    break;
                    case ("ora") :
                        time = LocalTime.now();
                        pr.println("ore: " + time);
                    break;
                    case ("id") :
                        pr.println("sei l'utente con l'id: " + getId());
                    break;
                    case ("nome") :
                        pr.println("sei l'utente con il nome: " + getName());
                    break;
                    case ("fine") :
                        StartStop = false;
                        pr.println("fine");
                    break;
                }
            }
            s.close();
        
        } catch (Exception e) {
            System.out.println("CIAO");
        }
            
    }
    
}