package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.OldEmployerService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerCase;
import kodlamaio.hrms.entities.concretes.OldEmployer;
import kodlamaio.hrms.entities.concretes.Verification;

@Service

public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationService verificationService;
	private OldEmployerService oldEmployerService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationService verificationService,
			OldEmployerService oldEmployerService) {
		super();
		this.employerDao = employerDao;
		this.verificationService = verificationService;
		this.oldEmployerService = oldEmployerService;
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
	public DataResult<Employer> getByIdForUsers(int id) {
		var value = employerDao.getByid(id);
		if(value.getEmployerCase().getId() == 1) {
			return new SuccessDataResult<Employer>(this.employerDao.getByid(id));
		}
		else if(value.getEmployerCase().getId() == 2) {
			return new SuccessDataResult(oldEmployerService.getbyEmployerid(id),(value.getEmployerCase().getCaseName()));
		}
		else {
			return new SuccessDataResult(oldEmployerService.getbyEmployerid(id),(value.getEmployerCase().getCaseName()).toString());
		}
		
	}


	@Override
	public Result update(Employer employer, int id) {
		var value = employerDao.getByid(id);
		var oldValue = new OldEmployer();
		oldValue.setCompanyName(value.getCompanyName());
		oldValue.setCompanysector(value.getCompanysector());
		oldValue.setEmail(value.getEmail());
		oldValue.setPassword(value.getPassword());
		oldValue.setPhoneNumber(value.getPhoneNumber());
		oldValue.setWebAddress(value.getWebAddress());
		oldValue.setEmployer(value);
		oldValue.setEmployerCase(employer.getEmployerCase());
		if(this.oldEmployerService.getbyEmployerid(id)== null) {
			this.oldEmployerService.add(oldValue);
		}
		else {
			var valueForUpdate = this.oldEmployerService.getbyEmployerid(id);
			valueForUpdate.setCompanyName(oldValue.getCompanyName());
			valueForUpdate.setCompanysector(oldValue.getCompanysector());
			valueForUpdate.setEmail(oldValue.getEmail());
			valueForUpdate.setPassword(oldValue.getPassword());
			valueForUpdate.setPhoneNumber(oldValue.getPhoneNumber());
			valueForUpdate.setWebAddress(oldValue.getWebAddress());
			valueForUpdate.setEmployer(value);
			valueForUpdate.setEmployerCase(employer.getEmployerCase());
		}
		
		value.setCompanyName(employer.getCompanyName());
		value.setEmail(employer.getEmail());
		value.setCompanysector(employer.getCompanysector());
		value.setPassword(employer.getPassword());
		value.setPhoneNumber(employer.getPhoneNumber());
		value.setWebAddress(employer.getWebAddress());
		value.setEmployerCase(employer.getEmployerCase());
		employerDao.save(value);
		return new SuccessResult();
	}



	@Override
	public Result ConfirmUpdate(EmployerCase employerCase, int EmployerId) {
		
		var value = employerDao.getByid(EmployerId);
		value.setEmployerCase(employerCase);
		employerDao.save(value);
		return new SuccessResult();
	}


	@Override
	public DataResult<Employer> getByIdForAdmins(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.getByid(id));
	}


	@Override
	public DataResult<List<Employer>> getByEmployerCase_id() {
		return new SuccessDataResult<List<Employer>>(employerDao.getByEmployerCase_id(2));
	}


	

	

}
