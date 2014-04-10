package com.jdwb.twitterapi;

import java.io.File;
import javax.swing.ImageIcon;
import rcaller.RCaller;
 
 
public class Test1 {
 
    /*public static void main(String[] args) {
        new Test1();
    }*/
 
   
    public Test1() {
        try {
        	             
        	RCaller caller = new RCaller();
            caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.0.2\\bin\\x64\\Rscript.exe");
           caller.setRExecutable("C:\\Program Files\\R\\R-3.0.2\\bin\\x64\\Rscript.exe");
            caller.cleanRCode();
           Runtime.getRuntime().exec("C:\\Program Files\\R\\R-3.0.2\\bin\\x64\\Rscript.exe F:/cmpe239/workspace/Twitter/src/com/jdwb/twitterapi/run.R");   //("run.R");
                System.out.println("start");
            System.out.println("end");
            	            
              
            
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
