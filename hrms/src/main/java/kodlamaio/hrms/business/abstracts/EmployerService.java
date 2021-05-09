package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
}
