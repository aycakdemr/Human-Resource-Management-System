package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanySectorService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CompanySectorDao;
import kodlamaio.hrms.entities.concretes.CompanySector;

@Service
public class CompanySectorManager implements CompanySectorService{

	private CompanySectorDao companySectorDao;
	
	@Autowired
	public CompanySectorManager(CompanySectorDao companySectorDao) {
		super();
		this.companySectorDao = companySectorDao;
	}


	@Override
	public DataResult<List<CompanySector>> getAll() {
		return new SuccessDataResult<List<CompanySector>>(companySectorDao.findAll());

	}

}
