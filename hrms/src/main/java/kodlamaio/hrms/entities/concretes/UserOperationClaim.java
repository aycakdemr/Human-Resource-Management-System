package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user_operation_claims")
public class UserOperationClaim {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="operation_claim_id")
	private int operationClaimId;
	
	public UserOperationClaim(int id, int userId, int operationClaimId) {
		super();
		this.id = id;
		this.userId = userId;
		this.operationClaimId = operationClaimId;
	}

	public UserOperationClaim() {
		super();
	}

}
