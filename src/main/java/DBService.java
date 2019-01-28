import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBService {

	private Connection con;

	private void connectToDb() {
		try {
			if(con == null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(Config.getProperty("connectionstring"));
			}
		} catch (Exception e) {
	    	e.printStackTrace();    
		}
	}
	
	private void closeConnection() {
		try {
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
	    	e.printStackTrace();    
		}
	}

	public ActionResult<List<Student>> getStudents() {
		connectToDb();
		ActionResult<List<Student>> result = new ActionResult<List<Student>>();
		PreparedStatement getStudents = null;     
		String insertString = "SELECT * FROM Students"; 		 
	    try {         
	    	getStudents = con.prepareStatement(insertString);   
	    	ResultSet rs = getStudents.executeQuery();
	    	List<Student> students = new ArrayList<Student>();
	    	while(rs.next()) {
	    		Student s = new Student();
	    		s.setStudentId(rs.getInt("studentId"));
	    		s.setFirstName(rs.getString("firstName"));
	    		s.setLastName(rs.getString("lastName"));
	    		s.setCreatedOn(rs.getDate("createdOn"));
	    		s.setModifiedOn(rs.getDate("modifiedOn"));
	    		s.setOib(rs.getString("oib"));
	    		s.setBirthDate(rs.getDate("birthDate"));
	    		s.setCountryOfBirth(rs.getString("countryOfBirth"));
	    		s.setPlaceOfBirth(rs.getString("placeOfBirth"));
	    		s.setEnrollmentDate(rs.getDate("enrollmentDate"));
	    		students.add(s);
	    	} 	
	    	result.setSuccessfull(students);
	    	return result;
	    } catch (SQLException e ) {   
	    	e.printStackTrace();
	    	result.setFailed(e.getErrorCode(), e.getMessage());
	    	return result;
	    } finally {
	    	 closeConnection();
	    }
	}

	public ActionResult<Boolean> updateStudent(Student student) {
		ActionResult<Boolean> result = new ActionResult<Boolean>();
		connectToDb();
		PreparedStatement insertMessage = null;     
		String insertString = "UPDATE Students SET firstName = ?, lastName = ?, oib = ?, modifiedOn = ?, birthDate = ?, countryOfBirth = ?, placeOfBirth = ?, enrollmentDate = ? WHERE studentId = ?"; 		 
	    try {         
	    	insertMessage = con.prepareStatement(insertString);   
	    	insertMessage.setString(1, student.getFirstName());   
	    	insertMessage.setString(2, student.getLastName());
	    	insertMessage.setString(3, student.getOib());
	    	insertMessage.setDate(4, new Date(new java.util.Date().getTime()));
	    	insertMessage.setDate(5, student.getBirthDate());
	    	insertMessage.setString(6, student.getCountryOfBirth());
	    	insertMessage.setString(7, student.getPlaceOfBirth());
	    	insertMessage.setDate(8, student.getEnrollmentDate());
	    	insertMessage.setInt(9, student.getStudentId());
	    	insertMessage.executeUpdate();
	    	
	    	result.setSuccessfull(true);
	    	return result;
	    } catch (SQLException e ) {   
	    	e.printStackTrace();
	    	result.setFailed(e.getErrorCode(), e.getMessage());
	    	return result;
	    } finally {
	    	 closeConnection();
	    }
	}

	public ActionResult<Boolean> insertStudent(Student student) {
		ActionResult<Boolean> result = new ActionResult<Boolean>();
		connectToDb();
		PreparedStatement insertMessage = null;     
		String insertString = "INSERT INTO Students(firstName, lastName, createdOn, oib, modifiedOn, birthDate, countryOfBirth, placeOfBirth, enrollmentDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 		 
	    try {         
	    	insertMessage = con.prepareStatement(insertString);   
	    	insertMessage.setString(1, student.getFirstName());   
	    	insertMessage.setString(2, student.getLastName());
	    	insertMessage.setDate(3, new Date(new java.util.Date().getTime()));
	    	insertMessage.setString(4, student.getOib());
	    	insertMessage.setDate(5, new Date(new java.util.Date().getTime()));
	    	insertMessage.setDate(6, student.getBirthDate());
	    	insertMessage.setString(7, student.getCountryOfBirth());
	    	insertMessage.setString(8, student.getPlaceOfBirth());
	    	insertMessage.setDate(9, student.getEnrollmentDate());
	    	insertMessage.executeUpdate();
	    	
	    	result.setSuccessfull(true);
	    	return result;
	    } catch (SQLException e ) {   
	    	e.printStackTrace();
	    	result.setFailed(e.getErrorCode(), e.getMessage());
	    	return result;
	    } finally {
	    	 closeConnection();
	    }
	}

	public ActionResult<Boolean> deleteStudent(Student student) {
		ActionResult<Boolean> result = new ActionResult<Boolean>();
		connectToDb();
		PreparedStatement insertMessage = null;     
		String insertString = "DELETE FROM Students WHERE studentId = ?"; 		 
	    try {         
	    	insertMessage = con.prepareStatement(insertString);   
	    	insertMessage.setInt(1, student.getStudentId());   
	    	insertMessage.executeUpdate();
	    	
	    	result.setSuccessfull(true);
	    	return result;
	    } catch (SQLException e ) {   
	    	e.printStackTrace(); 
	    	result.setFailed(e.getErrorCode(), e.getMessage());
	    	return result;
	    } finally {
	    	 closeConnection();
	    }
	}

}
