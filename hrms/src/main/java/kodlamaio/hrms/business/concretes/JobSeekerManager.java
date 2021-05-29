package kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.validation.MernisValidation;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.EMailVerificationService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	private JobSeekerDao jobSeekerDao;
	private MernisValidation<JobSeeker> mernisValidation;
	private EMailVerificationService<JobSeeker> verificationService;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisValidation<JobSeeker> mernisValidation,EMailVerificationService<JobSeeker>  verificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisValidation =mernisValidation;
		this.verificationService = verificationService;
	}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker JobSeeker) {
		
		Result result = BusinessRules.run(infosNullControl(JobSeeker),controlIdentificationNumber(JobSeeker),controlEMail(JobSeeker));
		if(!(mernisValidation.validate(JobSeeker).isSuccess())){
			return new ErrorResult("mernis doğrulama hatası");
		}
		if(!(verificationService.verification(JobSeeker).isSuccess())){
			return new ErrorResult("email doğrulama hatası");
		}
		if(result.isSuccess() ) {	
			this.jobSeekerDao.save(JobSeeker);
			return new SuccessResult("İş arayan eklendi");
			
		}
		return result;
		
	   
	}
	
	private Result infosNullControl(JobSeeker JobSeeker) {
		if(JobSeeker.getFirstName() == null) {
			return new ErrorResult("isim alanı boş geçilemez");
		}
		if(JobSeeker.getLastName() == null) {
			return new ErrorResult("soyisim alanı boş geçilemez");
		}
		if(JobSeeker.getPassword() == null) {
			return new ErrorResult("şifre alanı boş geçilemez");
		}
		if(JobSeeker.getEMail() == null) {
			return new ErrorResult("email alanı boş geçilemez");
		}
		if(JobSeeker.getIdentityNumber() == null) {
			return new ErrorResult("tcno alanı boş geçilemez");
		}
		else {
			return new SuccessResult();
		}
		
	}
	private Result controlIdentificationNumber(JobSeeker JobSeeker) {
		if(jobSeekerDao.getByidentityNumber(JobSeeker.getIdentityNumber()) != null){
	         return new ErrorResult("Aynı tcno zaten var.");
	    }
		return new SuccessResult();
	}
	private Result controlEMail(JobSeeker JobSeeker) {
		if(jobSeekerDao.getByeMail(JobSeeker.getEMail()) != null){
	         return new ErrorResult("Aynı email zaten var.");
	    }
		return new SuccessResult();
	}
}
