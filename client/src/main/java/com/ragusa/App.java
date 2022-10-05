package com.ragusa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Socket s = new Socket(InetAddress.getLocalHost(), 3000);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("ci sono");
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);

        String str = br.readLine();
        System.out.println("Server: " + str);
        s.close();
    }
}
