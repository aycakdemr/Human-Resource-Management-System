package kodlamaio.hrms.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","abilityJobSeekers","languageJobSeekers","schoolJobSeekers","socialMedias","workPlaceJobSeekers"})
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name = "image_id")
	private Image image;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<AbilityJobSeeker> abilityJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<LanguageJobSeeker> languageJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<SchoolJobSeeker> schoolJobSeekers;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<SocialMedia> socialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<WorkPlaceJobSeeker> workPlaceJobSeekers;
}
