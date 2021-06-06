package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationLevelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.EducationLevel;

@RestController
@RequestMapping("/api/educationlevels")
@CrossOrigin
public class EducationLevelsController {
	private EducationLevelService educationLevelService;

	@Autowired
	public EducationLevelsController(EducationLevelService educationLevelService) {
		super();
		this.educationLevelService = educationLevelService;
	}
	@GetMapping("/getall")
	public DataResult<List<EducationLevel>> getAll(){
		return this.educationLevelService.getAll();
	}
}
