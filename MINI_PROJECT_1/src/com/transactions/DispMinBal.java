package com.transactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.filemanagement.FilePath;

public class DispMinBal implements FilePath{
FileReader fr;
BufferedReader br;
String filePath = MASTER_PATH;
long phonenum;
String contact ;
int age;
public DispMinBal() {
	super();
	// TODO Auto-generated constructor stub
}

public void dispBal(int id,String pass) {
	
	try {
	fr = new FileReader(filePath);
	br = new BufferedReader(fr);
	String data = br.readLine();
	contact = String.valueOf(phonenum);
	
	while(data!=null) {
		StringTokenizer st = new StringTokenizer(data,"#");
		
		int balId = Integer.valueOf(st.nextToken());
		String name = st.nextToken();
		String sname = st.nextToken();
		String balPass = st.nextToken();
		age = Integer.parseInt(st.nextToken());
		contact = st.nextToken();
		int minBal = Integer.valueOf(st.nextToken());
		if(balId == id && balPass.trim().equals(pass)) {
				System.out.println("Name : "+name+" "+sname+"\n"+"Minimum Balance : Rs "+ minBal);
			}
		data = br.readLine();
	}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
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
}


}
