package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HowToWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.HowToWorkDao;
import kodlamaio.hrms.entities.concretes.HowToWork;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class HowToWorkManager implements HowToWorkService{

	private HowToWorkDao howToWorkDao;
	
	 @Autowired
	public HowToWorkManager(HowToWorkDao howToWorkDao) {
		super();
		this.howToWorkDao = howToWorkDao;
	}
	@Override
	public DataResult<List<HowToWork>> getAll() {
		return new SuccessDataResult<List<HowToWork>>(howToWorkDao.findAll());
	}

}
