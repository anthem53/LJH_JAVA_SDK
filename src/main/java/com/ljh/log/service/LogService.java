package com.ljh.log.service;

import java.util.List;

import com.ljh.log.entity.ProcessLogEntity;
import com.ljh.log.model.ProcessLog;

public interface LogService {
	/**
	 * <p>요청 조건에 맞는 데이터를 조회한다.</p>
	 * @return 처리 결과 목록
	 */
	List<ProcessLog> getAllLogs();

	/**
	 * <p>요청 조건에 맞는 데이터를 조회한다.</p>
	 * @return 처리 결과 목록
	 */
	List<ProcessLogEntity> getLogsByAppName();

	/**
	 * <p>요청 조건에 맞는 데이터를 조회한다.</p>
	 * @param id 대상 식별자
	 * @return 처리된 ProcessLogEntity 객체
	 */
	ProcessLogEntity getLogEntityById(String id);

	/**
	 * <p>입력값을 바탕으로 데이터 또는 객체를 생성한다.</p>
	 * @param processLog 처리에 사용할 입력값
	 * @return 처리된 ProcessLog 객체
	 */
	ProcessLog createLog(ProcessLog processLog);

	/**
	 * <p>대상 데이터를 최신 상태로 갱신한다.</p>
	 * @param id 대상 식별자
	 * @param processLog 처리에 사용할 입력값
	 * @return 처리된 ProcessLog 객체
	 */
	ProcessLog updateLog(String id, ProcessLog processLog);

	/**
	 * <p>지정한 대상 데이터를 삭제한다.</p>
	 * @param id 대상 식별자
	 */
	void deleteLog(String id);
}
