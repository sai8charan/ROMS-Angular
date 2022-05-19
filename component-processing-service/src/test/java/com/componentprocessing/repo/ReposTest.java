package com.componentprocessing.repo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.componentprocessing.model.ProcessRequest;
import com.componentprocessing.model.ProcessResponse;
import com.componentprocessing.repository.ProcessRequestRepository;
import com.componentprocessing.repository.ProcessResponseRepository;
@SpringBootTest
class ReposTest {
	@Autowired
	ProcessRequestRepository processRequestRepository;
	@Autowired
	ProcessResponseRepository processResponseRepository;
/*
 * This method is used to test whether request request details are saved to repo or not
 */
	@Test
	void isProcessRequestSaved() {
		
		ProcessRequest prequest = new ProcessRequest("HeyUserIamDuplicate", "815487890", "Integral", "Lappy", 5);
		prequest=processRequestRepository.save(prequest);
		boolean isNotnull =processRequestRepository.findById(prequest.getRequestId())!=null;
		assertThat(isNotnull).isTrue();
		processRequestRepository.deleteById(prequest.getRequestId());
	}
	/*
	 * This method is used to test whether response request details are saved to repo or not
	 */
	@Test
	void isProcessResponseSaved() {
		UUID uid = UUID.randomUUID();
		ProcessResponse prequest = new ProcessResponse(uid, 250, 380, new Date());
		boolean isNotnull =processResponseRepository.save(prequest)!=null;
		assertThat(isNotnull).isTrue();
		processResponseRepository.deleteById(uid);	}

}
