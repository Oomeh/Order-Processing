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

    /**
     * @param args the command line arguments
     */        
    
    /**
     * Fields
     */
        static String order;
        static String orderID;
        static String partNum;
        static double price;
        static int quantity;
        static final double TAX_RATE = 0.02;
        static final double SHIPPING_RATE = 0.07;        
        static float total;
        static File inFile;
        static File outFile;
        static BufferedReader reader;
        static PrintWriter writer;       
        static String[] splitter;
        static double tax;
        static double shipping;

    /**
     * Constructor that has the file locations hard coded
     */
    public OrderProcessor() {
        inFile = new File("/Volumes/Shared Files/Orders.txt");
        outFile = new File("OrdersProcessed.txt");       
    }
    
    /**
     * Accepts parameters for the files to open
     * @param in
     * @param out 
     */
    public OrderProcessor(File in, File out){
        inFile = in;
        outFile = out;
    }
     
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        OrderProcessor orderprocessor = new OrderProcessor();
        openFiles();
        readFile();
        closeFiles();
    }
    
    /**
     * Opens the files for reading and writing.
     */
    public static void openFiles(){
        try{
            reader = new BufferedReader((new FileReader(inFile)));            
            writer = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
        }
        catch(IOException e){
            System.out.println("File open failed");
        }
    }
    
    /**
     * Reads the opened file and calls the writeFile and calculate methods .
     */
    public static void readFile(){
        try{       
            System.out.println("Start processing orders");
            reader.readLine();
            order = reader.readLine();
            while(order != null && order.isEmpty() == false){
                writeFile();

                order = reader.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println("File read failed");
        }
    }   
    
    /**
     * Closes the opened files.
     */
    public static void closeFiles(){
        try{
            reader.close();
            writer.close(); 
        }
        catch(IOException e){
            System.out.println("File close failed");
        } 
        //End of processing
        System.out.println("Finished processing orders");     
    }
    
    /**
     * Splits up and writes the information read from the file into another file
     * and calls the calculate method to finish writing the pricing information.
     */
    public static void writeFile(){
        splitter = order.split("\\|");
        for(int i = 0; i < splitter.length; i++){
            switch(i){
                case 0: orderID = splitter[i];
                        writer.println("Order ID:   " + orderID);
                        break;
                case 1: partNum = splitter[i];
                        writer.println("Part Num:   " + partNum);
                        break;
                case 2: price = Double.parseDouble(splitter[i]);
                        writer.println("Price:      " + price);
                            break;
                case 3: quantity = Integer.parseInt(splitter[i]);
                        writer.println("Quantity:   " + quantity);
                        break;
                default: break;
                
            }
        }
        calculate();
        writer.println("Tax:        " + tax );                    
        writer.println("Shipping:   " + shipping);                
        writer.println("Total:      " + (price + tax + shipping));
        writer.println();
    }    
    
    /**
     * Calculates the price of shipping, tax, and the total and adds it to the file.
     */
    public static void calculate(){

        double product = price * quantity; 
        tax = product * TAX_RATE;
        shipping = product * SHIPPING_RATE; 
    }
}

