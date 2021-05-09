package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SystemUsers")
public class SystemUser {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="UserId")
	private int userId;

	@Column(name="Roles")
	private String roles;

	public SystemUser(int id, int userId, String roles) {
		super();
		this.id = id;
		this.userId = userId;
		this.roles = roles;
	}

	public SystemUser() {
		super();
	}
}
