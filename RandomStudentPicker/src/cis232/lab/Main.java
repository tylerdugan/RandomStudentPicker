package cis232.lab;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		String yesNo;
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Pick a student? (y/n)");
		yesNo = keyboard.nextLine().toUpperCase();
		
		while(yesNo.charAt(0)=='Y'){
			File students = new File("students.csv");
			Scanner input = new Scanner(students);
			ArrayList<String> studString = new ArrayList<>();
			ArrayList<Student> stds = new ArrayList<>();
			
			while(input.hasNextLine()){
				studString.add(input.nextLine());
			}
			
			int ranNum = random.nextInt(studString.size());			
	
			String studName = "";
			int studPoints = 0;
			
			
			System.out.printf("Did %s get it right? (y/n)", studName);
			String correct = keyboard.nextLine().toUpperCase();
			
			if(correct.charAt(0) == 'Y'){
				System.out.println("Great job! +1 point.");
				stds.get(ranNum).addPoint();
					
			}else{
				System.out.printf("Better luck next time! %s has %d points.", studName, studPoints);
			}
			//Loads object array
			for(int x = 0; x<studString.size(); x++){
				StringTokenizer token = new StringTokenizer(studString.get(ranNum), ",");
				studName = token.nextToken();
				studPoints = Integer.parseInt(token.nextToken());
				Student obj = new Student(studName, studPoints);
				stds.add(x,obj);
			}
			PrintWriter writer = new PrintWriter("students.csv");
			
			for(int i = 0; i<studString.size(); i++){
				writer.println(studString.get(i) + "," + studPoints);
			}
			writer.close();
			System.out.println("Pick a student? (y/n)");
			yesNo = keyboard.nextLine().toUpperCase();	
		}
	
	}

}
