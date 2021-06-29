package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.OldEmployer;

public interface OldEmployerService {
	Result add(OldEmployer oldEmployer);
	OldEmployer getbyEmployerid(int id);
}
