package com.componentprocessing.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.componentprocessing.model.ProcessRequest;
@Repository
public interface ProcessRequestRepository extends JpaRepository<ProcessRequest, UUID> {

}
