package kodlamaio.hrms.entities.dto;

import java.util.List;

import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDetailDto {
	private int jobSeekerId;
	private String imageUrl;
	private JobSeeker jobSeeker;
	private List<AbilityJobSeeker> abilities;
	private List<LanguageJobSeeker> languages;
	private List<SocialMedia> links;
	private List<SchoolJobSeeker> schools;
	private List<WorkPlaceJobSeeker> workplaces;
	
	public ResumeDetailDto(int jobSeekerId) {
		super();
		this.jobSeekerId = jobSeekerId;
	}
}
