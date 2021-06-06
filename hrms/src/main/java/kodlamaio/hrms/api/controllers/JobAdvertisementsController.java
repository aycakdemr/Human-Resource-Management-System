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

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return jobAdvertisementService.getAll();
	}
	@GetMapping("/getByIsActivated")
	public DataResult<List<JobAdvertisement>> getByIsActivated(){
		return jobAdvertisementService.getByIsActivated();
	}
	@GetMapping("/getAllSortedByDate")
	public DataResult<List<JobAdvertisement>> getAllSortedByDate(){
		return jobAdvertisementService.getAllSortedByDate();
	}
	@PostMapping("/delete")
	public Result delete(@RequestParam JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.delete(jobAdvertisement);
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	@PostMapping("/getByAdvertisementByCompany")
	public DataResult<List<JobAdvertisement>> getByAdvertisementByCompany(@RequestParam String companyName){
		return jobAdvertisementService.getByAdvertisementByCompany(companyName);
	}
	@PostMapping("/closeAdvertisement")
	public Result closeAdvertisement(@RequestParam int id) {
		return jobAdvertisementService.closeAdvertisement(id);
	}
}
