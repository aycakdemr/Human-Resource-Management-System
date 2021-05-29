package kodlamaio.hrms.business.validation;

import kodlamaio.hrms.core.utilities.results.Result;

public interface MernisValidation<T> {
	Result validate(T t);
}
