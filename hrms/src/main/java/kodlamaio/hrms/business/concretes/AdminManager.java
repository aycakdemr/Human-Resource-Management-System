package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AdminService;
import kodlamaio.hrms.dataAccess.abstracts.AdminDao;
import kodlamaio.hrms.entities.concretes.Admin;
@Service
public class AdminManager implements AdminService{

	private AdminDao adminDao;
	
	@Autowired
	public AdminManager(AdminDao adminDao) {
		super();
		this.adminDao = adminDao;
	}
	@Override
	public List<Admin> getAll() {
		
		return adminDao.findAll();
	}

}
