package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerCase;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return this.employerService.add(employer);
    }
	@PostMapping("/update")
	public Result update(@RequestBody Employer employer,@RequestParam int id) {
        return this.employerService.update(employer,id);

	}
	@GetMapping("/getByIdForUsers")
	public DataResult<Employer> getByIdForUsers(int id){
		 return this.employerService.getByIdForUsers(id);
	}
	@GetMapping("/getByIdForAdmins")
	public DataResult<Employer> getByIdForAdmins(int id){
		 return this.employerService.getByIdForAdmins(id);
	}
	@PostMapping("/ConfirmUpdate")
	public Result ConfirmUpdate(@RequestBody EmployerCase employerCase,@RequestParam int EmployerId) {
		return this.employerService.ConfirmUpdate(employerCase,EmployerId);
	}
	
	@GetMapping("/getByEmployerCaseId")
	public DataResult<List<Employer>> getByEmployerCase_id() {
		return this.employerService.getByEmployerCase_id();
	}
}
