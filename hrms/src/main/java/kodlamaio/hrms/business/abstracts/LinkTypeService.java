package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LinkType;

public interface LinkTypeService {
	DataResult<List<LinkType>> getAll();
	Result add(LinkType linkType);
}
