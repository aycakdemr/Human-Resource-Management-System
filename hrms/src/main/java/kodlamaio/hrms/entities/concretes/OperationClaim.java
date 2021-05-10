package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="operation_claims")
public class OperationClaim {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String Name;
	
	
	public OperationClaim(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}


	public OperationClaim() {
		super();
	}
}
