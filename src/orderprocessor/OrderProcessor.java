/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author bvance
 */
public class OrderProcessor {
    /**
     * 
     * @param input
     * @param output 
     */
    public OrderProcessor(File input, File output) {
        
    }
    /**
     * 
     */
    public OrderProcessor() {
        File inputFile = new File("/Volumes/Shared Files/Orders.txt");
        File outputFile = new File("OrdersProcessed.txt");
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    /**
     * 
     * @param inFile
     * @param outFile 
     */
    public void openFiles(File inFile, File outFile){
        try{
            BufferedReader in = new BufferedReader((new FileReader(inFile)));    
            BufferedReader out = new BufferedReader((new FileReader(outFile))); 
        }
        catch(IOException e){
            System.out.println("File read failed D:");
        }
    }

    public void closeFiles(File inFile, File outFile){
        
    }

    public void readOrders(File inFile, File outFile){
        inFile.
    }

    public void write(){
        
    }
}
