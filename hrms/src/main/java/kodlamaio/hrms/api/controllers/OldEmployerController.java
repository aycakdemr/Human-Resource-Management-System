package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.OldEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.OldEmployer;

@RestController
@RequestMapping("/api/oldemployers")
@CrossOrigin
public class OldEmployerController {
	private OldEmployerService oldEmployerService;

	@Autowired
	public OldEmployerController(OldEmployerService oldEmployerService) {
		super();
		this.oldEmployerService = oldEmployerService;
	}
	
	@GetMapping("/getbyEmployerid")
	public OldEmployer getbyEmployerid(int id) {
		return this.oldEmployerService.getbyEmployerid(id);
	}
	
}
