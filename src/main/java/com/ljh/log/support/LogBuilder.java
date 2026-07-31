package com.ljh.log.support;

import java.time.Instant;

import com.ljh.log.model.ProcessLog;

public class LogBuilder {

	/**
	 * <p>입력값을 바탕으로 데이터 또는 객체를 생성한다.</p>
	 * @param message 처리에 사용할 입력값
	 * @param detail 처리에 사용할 입력값
	 * @return 처리된 ProcessLog 객체
	 */
	public static ProcessLog buildProcessLog(String appName, String message, Object detail) {
		ProcessLog processLog = new ProcessLog();
		processLog.setAppName(appName);
		processLog.setTimestamp(Instant.now());
		processLog.setMessage(message);
		processLog.setDetail(detail);
		return processLog;
	}
}
