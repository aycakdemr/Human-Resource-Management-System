package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceService {
	DataResult<List<WorkPlace>> getAll();
	Result add(WorkPlace workPlace);
}
