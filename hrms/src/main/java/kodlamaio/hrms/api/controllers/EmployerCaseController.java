package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerCaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EmployerCase;

@RestController
@RequestMapping("/api/employercase")
@CrossOrigin
public class EmployerCaseController {

	private EmployerCaseService employerCaseService;
	
	@Autowired
	public EmployerCaseController(EmployerCaseService employerCaseService) {
		super();
		this.employerCaseService = employerCaseService;
	}

	@GetMapping("/getall")
	public DataResult<List<EmployerCase>> getAll(){
		return employerCaseService.getAll();
	}
}
