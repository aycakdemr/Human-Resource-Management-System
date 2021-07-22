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
import kodlamaio.hrms.entities.dto.JobAdvertFilterDto;

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
	@GetMapping("/getByIsActivatedTrue")
	public DataResult<List<JobAdvertisement>> getByIsActivatedTrue(){
		return jobAdvertisementService.getByIsActivatedTrue();
	}
	@GetMapping("/getByIsActivatedFalse")
	public DataResult<List<JobAdvertisement>> getByIsActivatedFalse(){
		return jobAdvertisementService.getByIsActivatedFalse();
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
	@GetMapping("/getTwoAdvert")
	public DataResult<List<JobAdvertisement>> getTwoAdvert() {
		return jobAdvertisementService.getTwoAdvert();
	}
	@GetMapping("/getbyId")
	public DataResult<List<JobAdvertisement>> getbyId(int id) {
		return jobAdvertisementService.getbyId(id);
	}
	
	@PostMapping("/getbyFilter")
	public DataResult<List<JobAdvertisement>> getbyFilter(@RequestParam int pageNo, @RequestParam int pageSize,@RequestBody JobAdvertFilterDto filter){
		return jobAdvertisementService.getbyFilter(pageNo, pageSize, filter);
	}
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id){
		return jobAdvertisementService.getByEmployerId(id);
	}
	
	@GetMapping("getByisActive")
    public DataResult<List<JobAdvertisement>> getByisActive(@RequestParam int pageNumber,
            @RequestParam int pageSize) {
        return this.jobAdvertisementService.getByisActive(pageNumber, pageSize);
    }
}
