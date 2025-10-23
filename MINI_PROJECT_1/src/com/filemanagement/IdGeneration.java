package com.filemanagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IdGeneration { 
	
	public IdGeneration() {
		super();
		// TODO Auto-generated constructor stub
				
	}
	public int getid(String filePath) {
		
		
		FileReader fr = null;
		BufferedReader br = null;
		int id = 0;
		try {
			fr = new FileReader(filePath); //file pointer / file handler 
			br = new BufferedReader(fr);

			//READ THE FIRST LINE 
			String lastid = null;
			String data = br.readLine();
			
			
			while(data != null) {
			//System.out.println(data);
			//data = br.readLine();
			lastid = data;
			data = br.readLine();
			}
			//id = Integer.parseInt(data);
				id = Integer.parseInt(lastid);
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		catch(NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}
}
