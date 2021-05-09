package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="JobPositionId")
	private int jobPositionId;
	
	@Column(name="UserId")
	private int userId;
	
	@Column(name="FirstName")
	private int firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="IdentityNumber")
	private String identityNumber;
	
	@Column(name="BirthYear")
	private String birthYear;
	
	@Column(name="IsValid")
	private boolean isValid;

	public Employee(int id, int jobPositionId, int userId, int firstName, String lastName, String identityNumber,
			String birthYear, boolean isValid) {
		super();
		this.id = id;
		this.jobPositionId = jobPositionId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthYear = birthYear;
		this.isValid = isValid;
	}

	public Employee() {
		super();
	}
}
