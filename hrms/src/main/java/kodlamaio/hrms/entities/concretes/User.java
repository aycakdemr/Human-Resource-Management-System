package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="EMail")
	private String eMail;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="PasswordRepeat")
	private String passwordRepeat;
	

	public User(int id, String eMail, String password, String passwordRepeat) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.password = password;
		this.passwordRepeat = passwordRepeat;
	}


	public User() {
		super();
	}

	
}
