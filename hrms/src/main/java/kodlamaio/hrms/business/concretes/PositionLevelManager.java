package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.PositionLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.PositionLevelDao;
import kodlamaio.hrms.entities.concretes.PositionLevel;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class PositionLevelManager implements PositionLevelService{

	private PositionLevelDao positionLevelDao;
	@Autowired
	public PositionLevelManager(PositionLevelDao positionLevelDao) {
		super();
		this.positionLevelDao = positionLevelDao;
	}

	@Override
	public DataResult<List<PositionLevel>> getAll() {
		return new SuccessDataResult<List<PositionLevel>>(positionLevelDao.findAll());
	}

}
