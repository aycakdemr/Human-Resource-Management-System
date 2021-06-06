package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Verification;

@Service

public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationService verificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationService verificationService) {
		super();
		this.employerDao = employerDao;
		this.verificationService = verificationService;
	}


	@Override
	public DataResult<List<Employer>> getAll() {
	
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}


	@Override
	public Result add(Employer employer) {
		
		Result result = BusinessRules.run(controlEMail(employer),infosNullControl(employer));
	
		if(result.isSuccess()) {	
			Verification v = new Verification();
			v.setUser(employer);
			v.setVerified(true);
			this.verificationService.add(v);
			this.employerDao.save(employer);
			return new SuccessResult("İş veren eklendi");
			
		}
		return result;
		
	}



	private Result controlEMail(Employer employer) {
		if(employerDao.getByemail(employer.getEmail()) != null){
	         return new ErrorResult("Aynı email zaten var.");
	    }
		return new SuccessResult();
	}
	
	
	private Result infosNullControl(Employer employer) {
		if(employer.getCompanyName() == null) {
			return new ErrorResult("şirket adı alanı boş geçilemez");
		}
		if(employer.getEmail() == null) {
			return new ErrorResult("email alanı boş geçilemez");
		}
		if(employer.getPassword() == null) {
			return new ErrorResult("şifre alanı boş geçilemez");
		}
		if(employer.getWebAddress() == null) {
			return new ErrorResult("web site alanı boş geçilemez");
		}
		else {
			return new SuccessResult();
		}
		
	}


	@Override
	public DataResult<Employer> getbyid(int id) {
		return new SuccessDataResult(employerDao.getByid(id));
	}

}
