package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;
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
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisements")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","approvedJobAdverts"})
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="wayofworking_id")
	private WayOfWorking wayofworking;
	
	@ManyToOne()
	@JoinColumn(name="howtowork_id")
	private HowToWork workType;
	
	@ManyToOne()
	@JoinColumn(name="positionLevel_id")
	private PositionLevel positionLevel;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="educationLevel_id")
	private EducationLevel educationLevel;
	
	@Column(name="advert_title")
	private String advertTitle;
	
	@Column(name="description",length = 2500)
	private String description;
	
	@Column(name="min_salary")
	private Double minSalary;
	
	@Column(name="max_salary")
	private Double maxSalary;
	
	@Column(name="quota")
	private int quota;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="is_active")
	private boolean isActive = true;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobAdvertisement")
	private List<ApprovedJobAdvert> approvedJobAdverts;

	
	
	
}
