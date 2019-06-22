package com.mp.hr.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mp.hr.dao.CandidateRepository;
import com.mp.hr.dao.ResumeRepository;
import com.mp.hr.model.Candidate;
import com.mp.hr.model.Resume;
import com.mp.hr.model.SuccessResponse;

import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

@Controller
public class CandidatesApiController implements CandidatesApi {

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private CandidateRepository candidateRepository;
    
    @Autowired
    private ResumeRepository resumeRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public CandidatesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<SuccessResponse> addCandidate(@ApiParam(value = "Candidate JSON Object"  )  @Valid @RequestBody Candidate candidate) {
    	ExampleMatcher NAME_MATCHER = ExampleMatcher.matching()
                .withMatcher("email", GenericPropertyMatchers.ignoreCase());
	    Example<Candidate> example = Example.<Candidate>of(candidate, NAME_MATCHER);
	    boolean exists = candidateRepository.exists(example);
    	
	    if(!exists)
	    {	
	    	Candidate savedCandidate = candidateRepository.save(candidate);
	    	SuccessResponse success = new SuccessResponse();
	    	success.setId(savedCandidate.getId());
	    	
	    	return new ResponseEntity<SuccessResponse>(success, HttpStatus.CREATED);
	    }
	    else {		
	    	return new ResponseEntity<SuccessResponse>(HttpStatus.CONFLICT);
	    }
    	
    }
    
    public ResponseEntity<SuccessResponse> deleteCandidate(@ApiParam(value = "Candidate's Id.",required=true) @PathVariable("candidateId") String candidateId) {
    	
    	Candidate candidate = candidateRepository.findOne(candidateId);
    	if(candidate!=null) {
	    	candidateRepository.delete(candidate);
	    	
	    	SuccessResponse success = new SuccessResponse();
	    	success.setId(candidate.getId());
	    	return new ResponseEntity<SuccessResponse>(success, HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<SuccessResponse>(HttpStatus.NOT_FOUND);
    	}
    }
    
    public ResponseEntity<Candidate> getCandidate(@ApiParam(value = "Candidate's Id.",required=true) @PathVariable("candidateId") String candidateId) {
    	Candidate candidate = candidateRepository.findOne(candidateId);
    	
    	
    	return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<List<Candidate>> getCandidates() {
    	List<Candidate> candidates = candidateRepository.findAll();
    	
    	return new ResponseEntity<List<Candidate>>(candidates, HttpStatus.OK);
    }
    
    public ResponseEntity<SuccessResponse> updateCandidate(@ApiParam(value = "Candidate JSON Object"  )  @Valid @RequestBody Candidate candidate) {
    	Candidate savedCandidate = candidateRepository.save(candidate);
    	SuccessResponse success = new SuccessResponse();
    	success.setId(savedCandidate.getId());
    			
    	return new ResponseEntity<SuccessResponse>(success, HttpStatus.CREATED);
    }
    
}
