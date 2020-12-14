import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

	private final String url = "jdbc:postgresql://localhost:5432/CovidTracer";
	private final String user = "postgres";
	private final String password = "Nn2Nm7PaNF#^";
	
	Connection c; 
	
	public DatabaseConnector() {
		this.c = connect(); 
	}

	public Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public boolean insertTestData(){
		try {
			StudentData data = new StudentData(); 
			for(int i = 0; i < data.createdStudents.size(); i++){
				//Insert every student into the DB 
				//Currently, person has first, middle, last name, email, phone, residence
				
				
				Person currentStudent = data.createdStudents.get(i);
				String insertQuery = "INSERT INTO public.\"Person\"(\"First Name\", \"Middle Name\", "
						+ "\"Last Name\", \"Email\", \"Phone\", \"Residence\") VALUES (?, ?, ?, ?, ?, ?);";
				PreparedStatement statement = c.prepareStatement(insertQuery);
				statement.setString(1, currentStudent.name.first); 
				statement.setString(2, currentStudent.name.middle);
				statement.setString(3, currentStudent.name.last);
				statement.setString(4, currentStudent.email);
				statement.setString(5, currentStudent.phone);
				statement.setString(6, currentStudent.address);
				statement.execute();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
	
	public void readFromDBTest() {
		Connection c = connect();
		try {
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM \"Test\";");
			while(rs.next()) {
				System.out.println(rs.getString("test"));
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertIntoDBTest() {
		Connection c = connect();
	}
	
}
