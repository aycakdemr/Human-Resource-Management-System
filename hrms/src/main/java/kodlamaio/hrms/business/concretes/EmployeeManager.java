package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;


@Service
public class EmployeeManager implements EmployeeService  {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
	}
	@Override
	public DataResult<List<Employee>> getById(int id) {
		return new SuccessDataResult<List<Employee>>(employeeDao.getByid(id));
	}
	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult();
	}
	@Override
	public Result update(Employee employee, int id) {
		var value = employeeDao.getByid(id).get(0);
		value.setFirstName(employee.getFirstName());
		value.setLastName(employee.getLastName());
		value.setEmail(employee.getEmail());
		value.setPassword(employee.getPassword());
		employeeDao.save(value);
		return new SuccessResult();
	}

}
