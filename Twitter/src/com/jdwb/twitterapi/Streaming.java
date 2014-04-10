package com.jdwb.twitterapi;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class Streaming {
	static short rowcount;

	static FileOutputStream out = null;
	static File f;
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	
	public Streaming(){
		f  = new File("src/com/jdwb/twitterapi/GalaxyS4.xls");
		if(f.exists()){			
			InputStream myxls;
			try {
				myxls = new FileInputStream("src/com/jdwb/twitterapi/GalaxyS4.xls");
				workbook = new HSSFWorkbook(myxls);
				sheet = workbook.getSheetAt(0);
				//System.out.println(sheet.getLastRowNum());
				rowcount = (short)(sheet.getLastRowNum() + 1);
				System.out.println("Existing number of rows : " + rowcount);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}							
		else{		
			try {				
				f.createNewFile();
				workbook = new HSSFWorkbook();
				sheet = workbook.createSheet("Sample sheet");				
				System.out.println("File Created");
				HSSFRow row = sheet.createRow(rowcount);
				row.createCell(0).setCellValue("Tweet");
				row.createCell(1).setCellValue("Continent");
				rowcount++;
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) throws IOException {
    	new Streaming();
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);	
        cb.setOAuthConsumerKey("EY0078WzmgwdYyGwNUPHw"); //J22eYgVIOWT3bPVAFWk6iw
        cb.setOAuthConsumerSecret("0XlwcxQkrB26eGD877hWacShAjyCXzIxv7ZGLDxnBc"); //gr26IqcKSWk4wz5yNi2cOVHdaXx2w9X71efu9eQBlo
        cb.setOAuthAccessToken("105828138-Zr9wGJteZaVtAcFuvLjR5l1XANYkq6siL0rStsef"); //631118946-AVRPOL3QCBZtCfbHHr3xZveHnrafsBCZUSbjlLgL
        cb.setOAuthAccessTokenSecret("IA2cLYzkRIYpstfsw5qTeTeDEIayHr8Vmi03XHbot3s6G"); //umdvNwUxOg9NkwneV1RVkgDCSa3phaLWQVxKu1dhblHW1
        final TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        
        StatusListener listener = new StatusListener() {
        	
        	@Override
            public void onException(Exception arg0) {

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {

            }

            @Override
            public void onStatus(Status status) {
            	double lon = status.getGeoLocation().getLongitude();
            	double lat = status.getGeoLocation().getLatitude();
            	//String location = status.getUser().getLocation();
            	String content = status.getText();                
            	String tmpcontent = content;
				double ASLAL = 11.62, ASLAU = 81.86, ASLOL = 27.33, ASLOU = 169.02; // Upper and lower bounds of Asia latitude and longitude
				double AULAL = -48, AULAU = -4, AULOL = 112, AULOU = 180;
				double AFLAL = -35, AFLAU = 35, AFLOL = -15, AFLOU = 52;
				double NALAL = 5, NALAU = 85 , NALOL = -165, NALOU =-15;
				double SALAL = -55, SALAU =12  , SALOL =-84   , SALOU = -35 ;
				double ELAL = 35, ELAU = 80 , ELOL = -10  , ELOU = 65 ;
				
				String contn = "";
				tmpcontent = tmpcontent.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", " ");
				content = tmpcontent.replace("\"", " ");
				
				  if(status.getGeoLocation()!=null){
						
						if(lat <= ASLAU && lat >=ASLAL && lon <=ASLOU && lon >= ASLOL){
							//System.out.println("Asia");
							contn="Asia";
						}
						else if(lat <= AULAU && lat >=AULAL && lon <=AULOU && lon >= AULOL){
							// Australia continent
							//System.out.println("Australia");
							contn="Australia";
							
						}
						else if(lat <= AFLAU && lat >=AFLAL && lon <=AFLOU && lon >= AFLOL){
							// Africa continent
							//System.out.println("Africa");
							contn="Africa";
						}
						else if(lat <= NALAU && lat >=NALAL && lon <=NALOU && lon >= NALOL){
							// North America continent
							//System.out.println("North America");
							contn="NorthAmerica";
						}
						else if(lat <= SALAU && lat >=SALAL && lon <=SALOU && lon >= SALOL){
							// South America continent
							//System.out.println("South America");
							contn="SouthAmerica";
							
						}
						else if(lat <= ELAU && lat >=ELAL && lon <=ELOU && lon >= ELOL){
							// Europe continent
							//System.out.println("Europe");
							contn="Europe";
						}
						else{
							contn = "NULL";
						}

				  }
				  else{					  
					contn = "NULL";
				  }

            	
                HSSFRow row = sheet.createRow(rowcount);
        		HSSFCell cell = row.createCell(0);
        		HSSFCell cell1 = row.createCell(1);
        		//HSSFCell cell2 = row.createCell(2);        		
        		//HSSFCell cell3 = row.createCell(3);        		
        		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        		cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
        		//cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
        		//cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
        		
        		cell.setCellValue(content.toLowerCase());        		
        		cell1.setCellValue(contn);
        		//cell1.setCellValue(lon);
        		//cell2.setCellValue(lat);
        		//cell3.setCellValue(location);
        		rowcount++;
        			
        		try {        	
        				out = new FileOutputStream(f);
        				workbook.write(out);        				
        				System.out.println("--" + rowcount + "--");        				
        				//out.close();
        				//new Process().process();
        				//twitterStream.shutdown();	
            		} catch (IOException e) {
            			e.printStackTrace();
            			System.out.println("Exception thrown while writing data in excel file");
            		}
        	}

            @Override
            public void onTrackLimitationNotice(int arg0) {

            }

			@Override
			public void onStallWarning(StallWarning arg0) {
				
			}

        };
        
        FilterQuery fq = new FilterQuery();
        String[] keywords = {"GalaxyS4", "galaxys4","Galaxy S4","galaxy s4"};
        String st[]={"en","english"};       
        fq.language(st);
        fq.track(keywords);
        twitterStream.addListener(listener);
        twitterStream.filter(fq);        				    
    
	}

}