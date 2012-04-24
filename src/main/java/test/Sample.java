package test;

import java.io.IOException;
import java.util.Scanner;

public class Sample {
	
	public static void main(String[] args){
		
//		System.err.println("입력");
//		Scanner scan = new Scanner(System.in);
//		String input = scan.next();
//		System.err.println("입력 : "+input);
		
		String sss = "012AB567";
        byte[] bytes = sss.getBytes();
        for(int i=0; i<bytes.length; i++){
        	System.out.println(i+"=>"+Byte.toString(bytes[i]));
        }
        for(int i=0; i<bytes.length; i++){
        	System.out.println(i+"=>"+((char)bytes[i]));
        }
        String test = "";
        test = new String(bytes,0,bytes.length);
        System.out.println("test================"+test);
		

        

        
        


        
        
	}
}
