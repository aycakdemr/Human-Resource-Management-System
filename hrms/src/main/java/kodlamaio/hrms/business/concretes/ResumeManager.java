package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityJobSeekerService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.LanguageJobSeekerService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.SchoolJobSeekerService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.business.abstracts.WorkPlaceJobSeekerService;
import kodlamaio.hrms.core.utilities.helpers.PhotoUploadHelper;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dto.ResumeDetailDto;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private AbilityJobSeekerService abilityJobSeekerService;
	private LanguageJobSeekerService languageJobSeekerService;
	private SchoolJobSeekerService schoolJobSeekerService;
	private SocialMediaService socialMediaService;
	private WorkPlaceJobSeekerService workPlaceJobSeekerService;
	private ImageService imageService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, AbilityJobSeekerService abilityJobSeekerService,
			LanguageJobSeekerService languageJobSeekerService, SchoolJobSeekerService schoolJobSeekerService,
			SocialMediaService socialMediaService, WorkPlaceJobSeekerService workPlaceJobSeekerService,
			ImageService imageService) {
		super();
		this.resumeDao = resumeDao;
		this.abilityJobSeekerService = abilityJobSeekerService;
		this.languageJobSeekerService = languageJobSeekerService;
		this.schoolJobSeekerService = schoolJobSeekerService;
		this.socialMediaService = socialMediaService;
		this.workPlaceJobSeekerService = workPlaceJobSeekerService;
		this.imageService = imageService;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll());
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult();
	}
	@Override
	public DataResult<ResumeDetailDto> getResumeWithDetails(int id) {
		var  resumedetail = new ResumeDetailDto();
		resumedetail.setImageUrl(imageService.getByjobSeeker_id(id).getData().getImagePath());
		resumedetail.setJobSeekerId(id);
		resumedetail.setJobSeeker(this.resumeDao.getResumeDetails(id).getJobSeeker());
		resumedetail.setSchools(schoolJobSeekerService.getByjobSeeker_id(id).getData());
		resumedetail.setWorkplaces(workPlaceJobSeekerService.getByjobSeeker_id(id).getData());
		resumedetail.setLanguages(languageJobSeekerService.getByjobSeeker_id(id).getData());
		resumedetail.setAbilities(abilityJobSeekerService.getByjobSeeker_id(id).getData());
		resumedetail.setLinks(socialMediaService.getByjobSeeker_id(id).getData());
		return new SuccessDataResult<ResumeDetailDto>(resumedetail);
	}

}
