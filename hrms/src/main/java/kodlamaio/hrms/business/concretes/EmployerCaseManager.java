package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerCaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerCaseDao;
import kodlamaio.hrms.entities.concretes.EmployerCase;
import kodlamaio.hrms.entities.concretes.LinkType;

@Service
public class EmployerCaseManager implements EmployerCaseService {

	private EmployerCaseDao employerCaseDao;
	
	@Autowired
	public EmployerCaseManager(EmployerCaseDao employerCaseDao) {
		super();
		this.employerCaseDao = employerCaseDao;
	}


	@Override
	public DataResult<List<EmployerCase>> getAll() {
		return new SuccessDataResult<List<EmployerCase>>(employerCaseDao.findAll());
		
	}

}
