package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="JobPositionId")
	private int jobPositionId;
	
	@Column(name="UserId")
	private int userId;
	
	@Column(name="CompanyName")
	private String companyName;
	
	@Column(name="WebSite")
	private String webSite;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;

	public Employer() {}
	
	
	public Employer(int id, int jobPositionId, int userId, String companyName, String webSite,
			String phoneNumber) {
		super();
		this.id = id;
		this.jobPositionId = jobPositionId;
		this.userId = userId;
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
	}
	
}
