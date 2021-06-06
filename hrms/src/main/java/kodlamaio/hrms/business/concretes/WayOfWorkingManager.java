package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WayOfWorkingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WayOfWorkingDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.WayOfWorking;

@Service
public class WayOfWorkingManager implements WayOfWorkingService {

	private WayOfWorkingDao wayOfWorkingdao;
	@Autowired
	public WayOfWorkingManager(WayOfWorkingDao wayOfWorkingdao) {
		super();
		this.wayOfWorkingdao = wayOfWorkingdao;
	}
	@Override
	public DataResult<List<WayOfWorking>> getAll() {
		return new SuccessDataResult<List<WayOfWorking>>(wayOfWorkingdao.findAll());
	}

}
