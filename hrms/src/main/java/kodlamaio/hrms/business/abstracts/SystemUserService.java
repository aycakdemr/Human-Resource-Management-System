package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	List<SystemUser> getAll();
}
