import java.sql.Date;
import com.google.gson.annotations.Expose;

public class Student {
	
	@Expose
	private Integer studentId;
	@Expose
	private String firstName;
	@Expose
	private String lastName;
	@Expose
	private Date createdOn;
	@Expose
	private Date modifiedOn;
	@Expose
	private String oib;
	@Expose
	private Date birthDate;
	@Expose
	private String countryOfBirth;
	@Expose
	private String placeOfBirth;
	@Expose
	private Date enrollmentDate;
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getOib() {
		return oib;
	}
	public void setOib(String oib) {
		this.oib = oib;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
}
