package org.jobstore.rest;

import java.util.List;

import org.jobstore.domain.Company;
import org.jobstore.domain.Job;
import org.jobstore.repository.CompanyRepository;
import org.jobstore.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/companies/{companyId}/jobs")
public class JobResource {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Job> createNewJob(@PathVariable("companyId") Long companyId, @RequestBody Job job){
		Company company = companyRepository.findOne(companyId);
		job.setCompany(company);
		jobRepository.save(job);
		return new ResponseEntity<Job>(job, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Job> findAllByCompany(@PathVariable("companyId") Long companyId){
		return jobRepository.findAllByCompany(companyRepository.findOne(companyId));
	}

}
