package com.mp.hr.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mp.hr.dao.ResumeRepository;
import com.mp.hr.model.Resume;
import com.mp.hr.service.StorageService;

import io.swagger.annotations.ApiParam;

@Controller
public class ResumeApiController implements ResumeApi {

	private final Logger log = LoggerFactory.getLogger(ResumeApiController.class);
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private StorageService storageService;
    
    @Autowired
    private ResumeRepository resumeRepository;
    
    @org.springframework.beans.factory.annotation.Autowired
    public ResumeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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

    @Override
    public ResponseEntity<Resume> resumePost(@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile upfile) {
    	log.info("Resume Upload Service:");
    	
    	storageService.store(upfile);
    	Resume resume = new Resume();
    	resume.setName(upfile.getOriginalFilename());
    	Resume storedResume = resumeRepository.insert(resume);
    	
    	return new ResponseEntity<Resume>(storedResume, HttpStatus.CREATED);
    }
    
    @Override
    public ResponseEntity<Resume> getResume(@ApiParam(value = "Resume's Id.",required=true) @PathVariable("resumeId") String resumeId) {
    	return new ResponseEntity<Resume>(resumeRepository.findOne(resumeId), HttpStatus.OK);
    }
}
