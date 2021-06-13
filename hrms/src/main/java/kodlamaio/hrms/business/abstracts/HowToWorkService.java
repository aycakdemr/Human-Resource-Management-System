package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.HowToWork;

public interface HowToWorkService {
	DataResult<List<HowToWork>> getAll();
}
