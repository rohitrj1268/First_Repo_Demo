package com.filemanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IdUpdation  {

	public IdUpdation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int updateId(String filePath) {
		IdGeneration idGen = new IdGeneration();
		int id = idGen.getid(filePath);
		int newid = id +1;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(filePath,true);
			bw = new BufferedWriter(fw);
		//	bw.newLine();
			//if we don't give String.valueof(newid) than it will write the uni-code character for that integer
			fw.write(String.valueOf(newid));
			fw.write("\n");
//FOR UNDERSTANDING PURPOSE	   : System.out.println("The new id is "+newid);      
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newid;
	}
}
