import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileParser {
	
	static ArrayList<String> firstNames; 
	static ArrayList<String> lastNames; 
	
	public FileParser(){
		try {
			parseNameFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void parseNameFiles() throws FileNotFoundException{
		ArrayList<String> firstNames = new ArrayList(); 
		firstNames = parseToList(new File("female.txt"), firstNames);
		ArrayList<String> additionalNames = new ArrayList(); 
		additionalNames = parseToList(new File("male.txt"), additionalNames);
		firstNames.addAll(additionalNames); 
		
		
		ArrayList<String> familyNames = new ArrayList(); 
		familyNames = parseToList(new File("family.txt"), familyNames);
		
		this.firstNames = firstNames; 
		this.lastNames = familyNames; 		
	}
	
	public ArrayList<String> parseToList(File file, ArrayList<String> list) throws FileNotFoundException{
		Scanner scanner = new Scanner(file); 
		int linecount = 0; 
		while(scanner.hasNext()){
			String nextLine = scanner.nextLine(); 
			list.add(nextLine); 
			linecount++; 
		}
		scanner.close();
		return list; 
	}
	
	public static Name getRandomName(){
		int randomFirstIndex = (int) (Math.random()*(firstNames.size())); 
		String randomFirstName = firstNames.get(randomFirstIndex); 
		int randomMiddleIndex = (int) (Math.random()*(firstNames.size())); 
		String randomMiddleName = firstNames.get(randomMiddleIndex);
		int randomLastIndex = (int) (Math.random()*(lastNames.size())); 
		String randomLastName = lastNames.get(randomLastIndex);
		return new Name(randomFirstName, randomMiddleName, randomLastName); 
	}
	
	
}
