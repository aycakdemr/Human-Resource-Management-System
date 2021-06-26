package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkPlaceJobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkPlaceJobSeeker;

@RestController
@RequestMapping("/api/workplacesjobseekers")
@CrossOrigin
public class WorkPlacesJobSeekersController {
	
	private WorkPlaceJobSeekerService workPlaceJobSeekerService;

	@Autowired
	public WorkPlacesJobSeekersController(WorkPlaceJobSeekerService workPlaceJobSeekerService) {
		super();
		this.workPlaceJobSeekerService = workPlaceJobSeekerService;
	}
	@GetMapping("/getall")
	public DataResult<List<WorkPlaceJobSeeker>> getAll(){
		return workPlaceJobSeekerService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody WorkPlaceJobSeeker workPlaceJobSeeker){
        return this.workPlaceJobSeekerService.add(workPlaceJobSeeker);
    }
	@PostMapping("/update")
	public Result update(@RequestBody WorkPlaceJobSeeker workPlaceJobSeeker,@RequestParam int id) {
		return this.workPlaceJobSeekerService.update(workPlaceJobSeeker,id);
	}
}
