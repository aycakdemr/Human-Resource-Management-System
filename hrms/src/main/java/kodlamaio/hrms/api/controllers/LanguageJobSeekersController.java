package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LanguageJobSeeker;

@RestController
@RequestMapping("/api/languagejobseekers")
public class LanguageJobSeekersController {
	private LanguageJobSeekerService languageJobSeekerService;

	@Autowired
	public LanguageJobSeekersController(LanguageJobSeekerService languageJobSeekerService) {
		super();
		this.languageJobSeekerService = languageJobSeekerService;
	}
	@GetMapping("/getall")
	public DataResult<List<LanguageJobSeeker>> getAll(){
		return languageJobSeekerService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody LanguageJobSeeker languageJobSeeker){
        return this.languageJobSeekerService.add(languageJobSeeker);
    
	}
}