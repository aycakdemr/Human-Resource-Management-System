package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
public class Employer {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String eMail;
	
	@Column(name="password")
	private String password;

	@Column(name="password_repeat")
	private String passwordRepeat;


	
}
