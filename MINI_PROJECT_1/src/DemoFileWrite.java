import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DemoFileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			System.out.println("Enter the text : ");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			FileWriter fw =  null;
			fw = new FileWriter("D:\\JAVA FULL STACK\\Test.txt",true);
			fw.write(input);
			fw.write("\n");
			
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
