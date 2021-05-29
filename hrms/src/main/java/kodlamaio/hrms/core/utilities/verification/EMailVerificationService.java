package kodlamaio.hrms.core.utilities.verification;

import kodlamaio.hrms.core.utilities.results.Result;

public interface EMailVerificationService<T> {
	Result verification(T t); 
}
