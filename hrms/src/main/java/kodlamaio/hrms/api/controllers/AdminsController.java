package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AdminService;
import kodlamaio.hrms.entities.concretes.Admin;


@RestController
@RequestMapping("/api/systemusers")
public class AdminsController {
	private AdminService adminService;

	@Autowired
	public AdminsController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	@GetMapping("/getall")
	public List<Admin> getAll(){
		return adminService.getAll();
	}
	
}