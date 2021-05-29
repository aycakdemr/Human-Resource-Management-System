package kodlamaio.hrms.core.utilities.verification;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class EMailVerification<T> implements EMailVerificationService<T>{

	@Override
	public Result verification(T t) {
		if(t.toString().contains("a")) {
			return new SuccessResult("email doğrulandı");
		}
		else {
			return new ErrorResult("email doğrulanamadı");
		}
	}
	
}
