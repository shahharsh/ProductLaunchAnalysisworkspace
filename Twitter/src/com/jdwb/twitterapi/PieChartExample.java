package com.jdwb.twitterapi;

import static com.googlecode.charts4j.Color.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import com.googlecode.charts4j.UrlUtil;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class PieChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }
   
    public void example1(int[] global) {
        // EXAMPLE CODE START
    	
        Slice s1 = Slice.newSlice(global[0], Color.newColor("CACACA"), "Positive", "Positive");
        Slice s2 = Slice.newSlice(global[1], Color.newColor("DF7417"), "Neutral", "Neutral");
        Slice s3 = Slice.newSlice(global[2], Color.newColor("951800"), "Negative", "Negative");
     //   Slice s4 = Slice.newSlice(10, Color.newColor("01A1DB"), "Internet Explorer", "Microsoft");

        PieChart chart = GCharts.newPieChart(s1, s2, s3);
        chart.setTitle("Global Analysis", BLACK, 16);
        chart.setSize(500, 200);
        chart.setThreeD(true);
        String url = chart.toURLString();
        System.out.println(url);
        BareBonesBrowserLaunch br = new BareBonesBrowserLaunch();
        br.openURL(url);
        
    }

    @SuppressWarnings("null")
	public void example2(int[][] global) {
        // EXAMPLE CODE START
    	String[] ctname = {"North America","South America","Asia", "Australia","Africa","Europe","Others"};
    	String[] ttype={"Positive","Neutral","Negative"};
    	//Slice s = new Slice(0, null, null, null);
    	PieChart chart=null;
    	
    	BareBonesBrowserLaunch br = new BareBonesBrowserLaunch();
    	for(int i =0; i<7;i++)
    	{
    		
    			int sum =0;
    		//	System.out.print(global[i][j]+"\t");
    			    
    			    	
    			    	sum=global[i][0]+global[i][1]+global[i][2];
    			    	//System.out.println("Sum ========="+sum);
    			    	
    			
    			//System.out.println("Percentage ========="+p);
    			
    		//	 s[j] = Slice.newSlice(p, ttype[j]);
    			Slice s1 = Slice.newSlice((int)Math.round(((global[i][0]*100)/sum)), Color.newColor("01A1DB"), (int)Math.round(((global[i][0]*100)/sum))+"%", "Positive "+global[i][0]+" out of "+sum);
    			Slice s2 = Slice.newSlice((int)Math.round(((global[i][1]*100)/sum)), Color.newColor("DF7417"), (int)Math.round(((global[i][1]*100)/sum))+"%", "Neutral "+global[i][1]+" out of "+sum);
    	        Slice s3 = Slice.newSlice((int)Math.round(((global[i][2]*100)/sum)), Color.newColor("951800"), (int)Math.round(((global[i][2]*100)/sum))+"%", "Negative "+global[i][2]+" out of "+sum);
    	        chart = GCharts.newPieChart(s1, s2, s3);
    	        
    	        
	
    		
    		
	        chart.setTitle("Analysis of "+ctname[i], BLACK, 16);
	        chart.setSize(500, 200);
	        chart.setThreeD(true);
	        String url = chart.toURLString();
	        System.out.println(url);
	        br.openURL(url);
    		System.out.println(ctname[i]);
    	}
                
    }
    

    public void example3(int[][] global,int[] g)
    {
        // EXAMPLE CODE START
    	
    	//Slice s = new Slice(0, null, null, null);
    	PieChart chart=null;
    	BareBonesBrowserLaunch br = new BareBonesBrowserLaunch();
    	Slice s1 = Slice.newSlice((int)Math.round(((global[0][0]*100)/g[0])), Color.newColor("DC3912"), (int)Math.round(((global[0][0]*100)/g[0]))+"%","North America "+(int)Math.round(((global[0][0]*100)/g[0]))+" %");
    	Slice s2 = Slice.newSlice((int)Math.round(((global[1][0]*100)/g[0])), Color.newColor("3B3EAC"), (int)Math.round(((global[1][0]*100)/g[0]))+"%","South America "+(int)Math.round(((global[1][0]*100)/g[0]))+" %");
    	Slice s3 = Slice.newSlice((int)Math.round(((global[2][0]*100)/g[0])), Color.newColor("E67300"), (int)Math.round(((global[2][0]*100)/g[0]))+"%","Asia "+(int)Math.round(((global[2][0]*100)/g[0]))+" %");
    	Slice s4 = Slice.newSlice((int)Math.round(((global[3][0]*100)/g[0])), Color.newColor("5574A6"), (int)Math.round(((global[3][0]*100)/g[0]))+"%","Australia "+(int)Math.round(((global[3][0]*100)/g[0]))+" %");
    	Slice s5 = Slice.newSlice((int)Math.round(((global[4][0]*100)/g[0])), Color.newColor("FF9900"), (int)Math.round(((global[4][0]*100)/g[0]))+"%","Africa "+(int)Math.round(((global[4][0]*100)/g[0]))+" %");
    	Slice s6 = Slice.newSlice((int)Math.round(((global[5][0]*100)/g[0])), Color.newColor("8B0707"), (int)Math.round(((global[5][0]*100)/g[0]))+"%","Europe "+(int)Math.round(((global[5][0]*100)/g[0]))+" %");
    	Slice s7 = Slice.newSlice((int)Math.round(((global[6][0]*100)/g[0])), Color.newColor("109618"), (int)Math.round(((global[6][0]*100)/g[0]))+"%","others "+(int)Math.round(((global[6][0]*100)/g[0]))+" %");
    	chart = GCharts.newPieChart(s1, s2, s3, s4, s5, s6, s7);
            chart.setTitle("Positive Tweets over the Globe ", BLACK, 16);
	        chart.setSize(500, 200);
	        chart.setThreeD(true);
	        String url = chart.toURLString();
	        System.out.println(url);
	        br.openURL(url);
    		//System.out.println(ctname[i]);
    	
                
    }
    public void example4(int[][] global,int[] g)
    {
        // EXAMPLE CODE START
    	
    	//Slice s = new Slice(0, null, null, null);
    	PieChart chart=null;
    	BareBonesBrowserLaunch br = new BareBonesBrowserLaunch();
    	Slice s1 = Slice.newSlice((int)Math.round(((global[0][1]*100)/g[1])), Color.newColor("DC3912"), (int)Math.round(((global[0][1]*100)/g[1]))+"%","North America "+(int)Math.round(((global[0][1]*100)/g[1]))+" %");
    	Slice s2 = Slice.newSlice((int)Math.round(((global[1][1]*100)/g[1])), Color.newColor("3B3EAC"), (int)Math.round(((global[1][1]*100)/g[1]))+"%","South America "+(int)Math.round(((global[1][1]*100)/g[1]))+" %");
    	Slice s3 = Slice.newSlice((int)Math.round(((global[2][1]*100)/g[1])), Color.newColor("E67300"), (int)Math.round(((global[2][1]*100)/g[1]))+"%","Asia "+(int)Math.round(((global[2][1]*100)/g[1]))+" %");
    	Slice s4 = Slice.newSlice((int)Math.round(((global[3][1]*100)/g[1])), Color.newColor("5574A6"), (int)Math.round(((global[3][1]*100)/g[1]))+"%","Australia "+(int)Math.round(((global[3][1]*100)/g[1]))+" %");
    	Slice s5 = Slice.newSlice((int)Math.round(((global[4][1]*100)/g[1])), Color.newColor("FF9900"), (int)Math.round(((global[4][1]*100)/g[1]))+"%","Africa "+(int)Math.round(((global[4][1]*100)/g[1]))+" %");
    	Slice s6 = Slice.newSlice((int)Math.round(((global[5][1]*100)/g[1])), Color.newColor("8B0707"), (int)Math.round(((global[5][1]*100)/g[1]))+"%","Europe "+(int)Math.round(((global[5][1]*100)/g[1]))+" %");
    	Slice s7 = Slice.newSlice((int)Math.round(((global[6][1]*100)/g[1])), Color.newColor("109618"), (int)Math.round(((global[6][1]*100)/g[1]))+"%","others "+(int)Math.round(((global[6][1]*100)/g[1]))+" %");
    	chart = GCharts.newPieChart(s1, s2, s3, s4, s5, s6, s7);
            chart.setTitle("Neutral tweets over the Globe ", BLACK, 16);
	        chart.setSize(500, 200);
	        chart.setThreeD(true);
	        String url = chart.toURLString();
	        System.out.println(url);
	        br.openURL(url);
    		//System.out.println(ctname[i]);
    	
                
    }

    public void example5(int[][] global,int[] g)
    {
        // EXAMPLE CODE START
    	
    	//Slice s = new Slice(0, null, null, null);
    	PieChart chart=null;
    	BareBonesBrowserLaunch br = new BareBonesBrowserLaunch();
    	Slice s1 = Slice.newSlice((int)Math.round(((global[0][2]*100)/g[2])), Color.newColor("DC3912"), (int)Math.round(((global[0][2]*100)/g[2]))+"%","North America "+(int)Math.round(((global[0][2]*100)/g[2]))+" %");
    	Slice s2 = Slice.newSlice((int)Math.round(((global[1][2]*100)/g[2])), Color.newColor("3B3EAC"), (int)Math.round(((global[1][2]*100)/g[2]))+"%","South America "+(int)Math.round(((global[1][2]*100)/g[2]))+" %");
    	Slice s3 = Slice.newSlice((int)Math.round(((global[2][2]*100)/g[2])), Color.newColor("E67300"), (int)Math.round(((global[2][2]*100)/g[2]))+"%","Asia "+(int)Math.round(((global[2][2]*100)/g[2]))+" %");
    	Slice s4 = Slice.newSlice((int)Math.round(((global[3][2]*100)/g[2])), Color.newColor("5574A6"), (int)Math.round(((global[3][2]*100)/g[2]))+"%","Australia "+(int)Math.round(((global[3][2]*100)/g[2]))+" %");
    	Slice s5 = Slice.newSlice((int)Math.round(((global[4][2]*100)/g[2])), Color.newColor("FF9900"), (int)Math.round(((global[4][2]*100)/g[2]))+"%","Africa "+(int)Math.round(((global[4][2]*100)/g[2]))+" %");
    	Slice s6 = Slice.newSlice((int)Math.round(((global[5][2]*100)/g[2])), Color.newColor("8B0707"), (int)Math.round(((global[5][2]*100)/g[2]))+"%","Europe "+(int)Math.round(((global[5][2]*100)/g[2]))+" %");
    	Slice s7 = Slice.newSlice((int)Math.round(((global[6][2]*100)/g[2])), Color.newColor("109618"), (int)Math.round(((global[6][2]*100)/g[2]))+"%","others "+(int)Math.round(((global[6][2]*100)/g[2]))+" %");
    	chart = GCharts.newPieChart(s1, s2, s3, s4, s5, s6, s7);
            chart.setTitle("Negative tweets over the Globe ", BLACK, 16);
	        chart.setSize(500, 200);
	        chart.setThreeD(true);
	        String url = chart.toURLString();
	        System.out.println(url);
	        br.openURL(url);
    		//System.out.println(ctname[i]);
    	
                
    }
}