package com.mp.hr.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mp.hr.model.Resume;

public interface ResumeRepository extends MongoRepository<Resume, String>{

}
