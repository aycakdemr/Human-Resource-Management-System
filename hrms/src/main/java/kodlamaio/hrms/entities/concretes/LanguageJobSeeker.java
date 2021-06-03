package kodlamaio.hrms.entities.concretes;

import javax.persistence.CascadeType;
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
@Table(name="language_jobseekers")
public class LanguageJobSeeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="language_level_id")
	private LanguageLevel languageLevel;
	
	@ManyToOne()
	@JoinColumn(name="language")
	private Language language;
	
	@ManyToOne()
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobseeker;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
