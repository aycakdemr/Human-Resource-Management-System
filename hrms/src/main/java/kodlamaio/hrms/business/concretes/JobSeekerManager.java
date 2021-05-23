package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getByIdentificationNumber(String identificationNumber) {
		return new SuccessDataResult<>(this.jobSeekerDao.getByidentityNumber(identificationNumber));
	}
	@Override
	public Result add(JobSeeker JobSeeker) {
		if(getByIdentificationNumber(JobSeeker.getIdentityNumber()).getData() != null){
	         return new ErrorResult("Aynı tcno zaten var.");
	    }
	   this.jobSeekerDao.save(JobSeeker);
	   return new SuccessResult("İş arayan eklendi");
	}
	
}
