package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CompanySectorService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CompanySector;

@RestController
@RequestMapping("/api/companysectors")
@CrossOrigin
public class CompanySectorsController {
	private CompanySectorService companySectorService;

	@Autowired
	public CompanySectorsController(CompanySectorService companySectorService) {
		super();
		this.companySectorService = companySectorService;
	}
	@GetMapping("/getall")
	public DataResult<List<CompanySector>> getAll(){
		return this.companySectorService.getAll();
	}
	
}
