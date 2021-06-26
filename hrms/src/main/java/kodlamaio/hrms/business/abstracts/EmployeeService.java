package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	DataResult<List<Employee>> getById(int id);
	Result add(Employee employee);
	Result update(Employee employee,int id);
}
