package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.HowToWorkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.HowToWork;

@RestController
@RequestMapping("/api/howtoworks")
@CrossOrigin
public class HowToWorksController {
	private HowToWorkService howToWorkService;

	@Autowired
	public HowToWorksController(HowToWorkService howToWorkService) {
		super();
		this.howToWorkService = howToWorkService;
	}
	@GetMapping("/getall")
	 public DataResult<List<HowToWork>> getAll(){
		return howToWorkService.getAll();
	}
	
}
