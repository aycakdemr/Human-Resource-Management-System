package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerCase;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
	Result ConfirmUpdate(EmployerCase employerCase,int EmployerId);
	Result update(Employer employer,int id);
	DataResult<Employer> getByIdForUsers(int id);
	DataResult<Employer> getByIdForAdmins(int id);
}
