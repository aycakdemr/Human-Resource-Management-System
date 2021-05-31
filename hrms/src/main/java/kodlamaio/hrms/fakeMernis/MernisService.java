package kodlamaio.hrms.fakeMernis;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public class MernisService {
	
	public static boolean Validate(JobSeeker jobSeeker) {
		if(!(jobSeeker.getEmail().contains("@"))) {
			return false;
		}
		if((jobSeeker.getIdentityNumber().length()!= 11)) {
			return false;
		}
		if((jobSeeker.getIdentityNumber().startsWith("0"))) {
			return false;
		}
		if((jobSeeker.getFirstName().length()> 20)) {
			return false;
		}
		if((jobSeeker.getLastName().length()> 30)) {
			return false;
		}
		if((jobSeeker.getPassword().length() < 5)) {
			return false;
		}
		return true;
	}
}
