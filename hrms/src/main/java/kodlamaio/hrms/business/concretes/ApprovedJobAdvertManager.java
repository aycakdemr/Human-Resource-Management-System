package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApprovedJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ApprovedJobAdvertDao;
import kodlamaio.hrms.entities.concretes.ApprovedJobAdvert;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class ApprovedJobAdvertManager implements ApprovedJobAdvertService{

	private ApprovedJobAdvertDao approvedJobAdvertDao;
	
	@Autowired
	public ApprovedJobAdvertManager(ApprovedJobAdvertDao approvedJobAdvertDao) {
		super();
		this.approvedJobAdvertDao = approvedJobAdvertDao;
	}


	@Override
	public DataResult<List<ApprovedJobAdvert>> getAll() {
		return new SuccessDataResult<List<ApprovedJobAdvert>>(approvedJobAdvertDao.findAll());
	}

}
