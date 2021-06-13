package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AbilityJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.AbilityJobSeeker;

@RestController
@RequestMapping("/api/abilityjobseekers")
@CrossOrigin
public class AbilityJobSeekersController {
	private AbilityJobSeekerService abilityJobSeekerService;

	@Autowired
	public AbilityJobSeekersController(AbilityJobSeekerService abilityJobSeekerService) {
		super();
		this.abilityJobSeekerService = abilityJobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<AbilityJobSeeker>> getAll(){
		return abilityJobSeekerService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody AbilityJobSeeker abilityJobSeeker){
        return this.abilityJobSeekerService.add(abilityJobSeeker);
    }
	
	
}
