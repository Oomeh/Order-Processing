/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bvance
 */
public class OrderProcessor {
    
    int OrderID;
    int PartNum;
    static File inputFile;
    static File outputFile;
    static BufferedReader in;
    /**
     * 
     * @param input
     * @param output 
     */
    public OrderProcessor(File input, File output) {
        openFiles(input, output);
        readOrders(in);
    }
    /**
     * 
     */
    public OrderProcessor() {
        inputFile = new File("/Volumes/Shared Files/Orders.txt");
        outputFile = new File("OrdersProcessed.txt");
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        openFiles(inputFile, outputFile);
        readOrders(in);
    }
    /**
     * 
     * @param inFile
     * @param outFile 
     */
    public static void openFiles(File inFile, File outFile){
        try{
            in = new BufferedReader((new FileReader(inFile)));    
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
        }
        catch(IOException e){
            System.out.println("File open failed >:");
        }
    }

    public static void closeFiles(BufferedReader inFile, PrintWriter outFile){
        try{
            inFile.close();
            outFile.close();
        }
        catch(IOException e)
        {
            System.out.println("File close failed D:");
        }

    }

    public static void readOrders(BufferedReader inFile){
        try{
            inFile.readLine();
        
        }
        catch(IOException e)
        {
            System.out.println("File read failed T~T");
        }
    }

    public void write(PrintWriter outFile){
        outFile.println("Order ID:");
        outFile.println("Part Num:");
        outFile.println("Price:");
        outFile.println("Quantity:");
        outFile.println("Tax:");
        outFile.println("Shipping:");
        outFile.println("Total:");
    }
}
