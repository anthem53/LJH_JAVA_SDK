package com.ljh.log.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ljh.log.model.ProcessLog;

public interface LogRepository extends MongoRepository<ProcessLog, String> {

	/**
	 * <p>요청 조건에 맞는 데이터를 조회한다.</p>
	 * @param appName 대상 이름
	 * @return 처리 결과 목록
	 */
	List<ProcessLog> findByAppNameOrderByTimestampDesc(String appName);
}
