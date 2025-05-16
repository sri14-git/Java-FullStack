package com.example.jpaintro.repo;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpaintro.model.JobPost;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {



}
