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
public class Employee{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="jobPosition_id")
	private int jobpositionId;

	public Employee() {
	}
	public Employee(int id, int userId, int JobpositionId) {
		super();
		this.id = id;
		this.userId = userId;
		this.jobpositionId = JobpositionId;
	}

	
}


