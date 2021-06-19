package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ApprovedJobAdvert;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface ApprovedJobAdvertService {
	DataResult<List<ApprovedJobAdvert>> getAll();
	Result add(ApprovedJobAdvert approvedJobAdvert);
}
