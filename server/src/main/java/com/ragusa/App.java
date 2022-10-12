package com.ragusa;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
            Socket s = ss.accept();
            System.out.println("Client connesso");


            // per parlare
            PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
              
            // per ascoltare
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            System.out.println(br.readLine()); 
            pr.println("Dammi er tu peso"); 
            String peso = br.readLine(); 
            System.out.println("peso ricevuto");
            pr.println("Dammi l'altezza"); 
            String altezza = br.readLine(); 
            System.out.println("altezza ricevuta");

            Double bmi = Double.valueOf(peso) / (Double.valueOf(altezza) * Double.valueOf(altezza));

            int scelta = bmi.intValue();

            pr.println(bmi);

            if(scelta < 16){
                pr.println("Sottopeso severo");
            }else if (scelta > 16 && bmi < 18){
                pr.println("Sottopeso");
            }else if(scelta > 18 && bmi < 24){
                pr.println("Normale");
            }else if(scelta > 25 && bmi < 30){
                pr.println("Sovrappeso");
            }else if(scelta > 31 && bmi < 35){
                pr.println("Obesità primo grado");
            }else if(scelta > 36 && bmi < 40){
                pr.println("Obesità secondo grado");
            }else{
                pr.println("Obesità terzo grado");
            }
            
            System.out.println(br.readLine());
            
            s.close();
            ss.close();
    }
}

