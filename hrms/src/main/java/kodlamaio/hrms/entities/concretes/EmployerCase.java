package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employer_cases")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employers"})
public class EmployerCase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="case_name")
	private String caseName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employerCase")
	private List<Employer> employers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employerCase")
	private List<OldEmployer> oldEmployer;
	

}
