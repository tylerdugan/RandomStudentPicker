package cis232.lab;

public class Student {
	String name;
	int points;
	
	public Student(String name, int points){
		this.name = name;
		this.points = points;
	}
	
	public void addPoint(){
		points++;
	}
}
