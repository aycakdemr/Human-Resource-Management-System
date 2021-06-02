package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkPlaceDao;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.WorkPlace;

@Service
public class WorkPlaceManager implements WorkPlaceService{

	private WorkPlaceDao workPlaceDao;
	
	@Autowired
	public WorkPlaceManager(WorkPlaceDao workPlaceDao) {
		super();
		this.workPlaceDao = workPlaceDao;
	}

	@Override
	public DataResult<List<WorkPlace>> getAll() {
		return new SuccessDataResult<List<WorkPlace>>(workPlaceDao.findAll());
	}

	@Override
	public Result add(WorkPlace workPlace) {
		this.workPlaceDao.save(workPlace);
		return new SuccessResult();
	}

}
