package kodlamaio.hrms.api.controllers;

import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.el.parser.ParseException;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dto.ResumeDetailDto;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll(){
		return resumeService.getAll();
	}
	@PostMapping("/add")
    public Result add(@RequestBody Resume resume){
        return this.resumeService.add(resume);
    }
	/*@GetMapping("/getByCandidateCandidateId")
	public DataResult<List<Resume>> getByCandidate_CandidateId(int candidateId){
		return this.resumeService.getByCandidate_CandidateId(candidateId);
	}*/
	@GetMapping("/getResumeWithDetails")
	public DataResult<ResumeDetailDto> getResumeWithDetails(@RequestParam int id) {
		return this.resumeService.getResumeWithDetails(id);
	}
	
	
}
