package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ApprovedJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ApprovedJobAdvert;

@RestController
@RequestMapping("/api/approvedjobAdverts")
@CrossOrigin
public class ApprovedJobAdvertsController {
	private ApprovedJobAdvertService approvedJobAdvertService;

	@Autowired
	public ApprovedJobAdvertsController(ApprovedJobAdvertService approvedJobAdvertService) {
		super();
		this.approvedJobAdvertService = approvedJobAdvertService;
	}
	@GetMapping("/getall")
	public DataResult<List<ApprovedJobAdvert>> getAll(){
		return approvedJobAdvertService.getAll();
	}
}
