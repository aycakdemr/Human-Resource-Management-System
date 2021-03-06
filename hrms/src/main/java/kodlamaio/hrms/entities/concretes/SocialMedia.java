package kodlamaio.hrms.entities.concretes;

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
@Table(name="social_medias")
public class SocialMedia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="jobseeker_id")
	private JobSeeker jobseeker;
	
	@ManyToOne()
	@JoinColumn(name="link_type_id")
	private LinkType linkType;
	
	
	@Column(name="link")
	private String link;
	
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
