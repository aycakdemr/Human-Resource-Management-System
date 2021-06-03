package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolJobSeeker;

@RestController
@RequestMapping("/api/schooljobseekers")
public class SchoolJobSeekerController {
	private SchoolJobSeekerService schoolJobSeekerService;

	@Autowired
	public SchoolJobSeekerController(SchoolJobSeekerService schoolJobSeekerService) {
		super();
		this.schoolJobSeekerService = schoolJobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SchoolJobSeeker>> getAll(){
		return schoolJobSeekerService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody SchoolJobSeeker schoolJobSeeker){
        return this.schoolJobSeekerService.add(schoolJobSeeker);
    }
	@GetMapping("/getAllSorted")
	public DataResult<List<SchoolJobSeeker>> getAllSorted(@RequestParam int jobSeekerId){
		return this.schoolJobSeekerService.getAllSorted(jobSeekerId);
	}
}
