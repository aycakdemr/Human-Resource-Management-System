package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {
	private AbilityService abilityService;

	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		super();
		this.abilityService = abilityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Ability>> getAll(){
		return abilityService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody Ability ability){
        return this.abilityService.add(ability);
    }
	
}
