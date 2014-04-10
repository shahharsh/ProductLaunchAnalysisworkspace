package com.jdwb.twitterapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class Process {
	static short rowcount;
	static int colcount;
	static FileOutputStream out = null;
	static File f;
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	
	public static void main(String[] args) throws IOException {
		ToCSV.convert();

		Test1 t = new Test1();
		File f = new File("src/com/jdwb/twitterapi/result.csv");
		  while(!f.exists()){
          	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
		int[][] output = Score.fetchresult();
		int[] global = Score.getGlobal(output);
		print(output, global);
		PieChartExample p = new PieChartExample();
		p.example1(global);
		p.example2(output);
		p.example3(output,global);
		p.example4(output,global);
		p.example5(output,global);
				
	}
	
	private static void print(int[][] a, int[] s){
		System.out.println("----------------------------------");
		System.out.println("Output {Positive, Neutral, Negative}\n");
		
		for(int i=0; i<7; i++){
			for(int j=0; j<3; j++){
				System.out.print(a[i][j] + " \t ");
			}								
			System.out.println();				
		}
		System.out.println("-----------------------");
		for(int j=0; j<3; j++)
			System.out.print(s[j] + " \t ");
	
	}
			
}