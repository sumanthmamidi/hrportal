package com.mp.hr.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mp.hr.model.Candidate;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String>{

}
