package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobPositions")
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="PositionName")
	private int positionName;

	public JobPosition(int id, int positionName) {
		super();
		this.id = id;
		this.positionName = positionName;
	}

	public JobPosition() {
		super();
	}
}
