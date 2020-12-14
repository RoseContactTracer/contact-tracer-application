
public class TestDataScript {
	
	public static void main(String[] args){
		FileParser f = new FileParser(); 
		StudentData s = new StudentData(); 
		DatabaseConnector dbCon = new DatabaseConnector(); 
		boolean thing = dbCon.insertTestData();
		System.out.println("Insertion worked: " + thing); 
	}

}
