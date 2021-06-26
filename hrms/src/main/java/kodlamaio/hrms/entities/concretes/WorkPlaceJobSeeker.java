package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="workplace_jobseekers")
public class WorkPlaceJobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="workplace_name")
	private String workplaceName;
	
	@ManyToOne()
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobseeker;
	
	@Column(name="date_of_entry")
	private int dateOfEntry;
	
	@Column(name="date_of_leaving")
	private int dateOfLeaving;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
