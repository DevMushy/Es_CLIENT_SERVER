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
        System.out.println("server in ascolto sulla porta 3000");
        Socket s = ss.accept();
        System.out.println("Client connesso");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        System.out.println("Client: " + str);
        

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("ben arrivato");
        pr.flush();
        s.close();
        ss.close();
    }
}

