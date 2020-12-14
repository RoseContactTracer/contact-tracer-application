import java.util.ArrayList;

public class StudentData {
	ArrayList<Person> createdStudents; 
	
	public StudentData(){
		createdStudents = new ArrayList(); 
		createStudents(100); 
	}
	
	public void createStudents(int numStudents) {
		for(int i = 0; i < numStudents; i++) {
			Person student = new Person(); 
			createdStudents.add(student); 
		}
	}
	
}
