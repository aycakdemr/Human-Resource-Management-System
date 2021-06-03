package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolJobSeekers","languageJobSeekers","abilityJobSeekers","workPlaceJobSeekers","socialMedias","resumes","images"})

public class JobSeeker extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="birth_date")
	private int birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<SchoolJobSeeker> schoolJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<LanguageJobSeeker> languageJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<AbilityJobSeeker> abilityJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<WorkPlaceJobSeeker> workPlaceJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<SocialMedia> socialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Resume> resumes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseeker")
	private List<Image> images;
}
