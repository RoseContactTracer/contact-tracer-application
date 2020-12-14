
public class Person {
	Name name; 
	String email; 
	String phone; 
	String address;
	
	public Person() {
		this.name = FileParser.getRandomName();
		this.email = getEmailFromName(name); 
		this.phone = createRandomPhone(); 
		this.address = "Pretend Address Here"; 
	}
	
	public String getEmailFromName(Name name){
		String email = ""; 
		String partialLast = ""; 
		if(name.last.length() > 5){
			partialLast = name.last.substring(0, 5); 
		}
		else {
			partialLast = name.last; 
		}
		email += partialLast + name.first.charAt(0) + name.middle.charAt(0); 
		return email; 
	}
	
	public String createRandomPhone(){
		String phone = ""; 
		for(int i = 0; i < 10; i++){
			int randomVal = (int) (Math.random()*10); 
			phone+= randomVal;
		}
		return phone; 
	}
}
