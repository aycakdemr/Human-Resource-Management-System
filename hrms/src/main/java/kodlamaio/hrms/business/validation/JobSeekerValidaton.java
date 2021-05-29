package kodlamaio.hrms.business.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerValidaton implements MernisValidation<JobSeeker>{

	@Override
	public Result validate(JobSeeker t) {
		String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr = t.getEMail();
	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    if(t.getIdentityNumber().length() != 11) {
			return new ErrorResult("Doğrulama Başarısız(tcno 11 haneli olmalıdır.)");
		}
	    if(! matcher.matches()) {
	    	return new SuccessResult("Doğrulama Başarısız(geçersiz email girişi)");
	    }
	    return new SuccessResult("Doğrulama Başarılı");
	    
	}

}
