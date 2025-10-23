package com.filemanagement;

import com.maintab.SwitchMain;

public class TempMain implements FilePath{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*				TO TEST ID GENERATION AND UPDATION
		 * IdGeneration readid;
		readid = new IdGeneration();
		readid.getid("d:\\JAVA FULL STACK\\MINI_PROJECT_1\\ID.txt");*/
		//String filePath = "d:\\\\JAVA FULL STACK\\\\MINI_PROJECT_1\\\\ID.txt";
		
		//				TO TEST BANK SIGN-UP
		//BankSignUp bsup = new BankSignUp();
		//bsup.signUpData();
		
		//				TO TEST BANK SIGN-IN
		//BankSignIn sup = new BankSignIn();
		//sup.signin();
		
		SwitchMain sm = new SwitchMain();
		sm.mainCon();
		
	}

}
