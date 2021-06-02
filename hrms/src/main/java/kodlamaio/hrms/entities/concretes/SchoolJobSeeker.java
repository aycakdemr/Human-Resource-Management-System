package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="school_jobseekers")
public class SchoolJobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="school_department_id")
	private SchoolDepartment schoolDepartment;
	
	@ManyToOne()
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSeeker;
	
	@Column(name="date_of_entry")
	private LocalDate dateOfEntry;
	
	@Column(name="date_of_graduation")
	private LocalDate dateOfGraduation;
}
