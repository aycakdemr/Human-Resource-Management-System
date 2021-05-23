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
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String eMail;
	
	@Column(name="password")
	private String password;

	@Column(name="password_repeat")
	private String passwordRepeat;


	public User(int id, String eMail, String password) {
		super();
		this.id = id;
		this.eMail = eMail;
		this.password = password;
	}


	public User() {
		super();
	}

	
}
