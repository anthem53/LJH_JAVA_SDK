package com.ljh.log.entity;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.ljh.log.model.ProcessLog;
import com.ljh.util.JsonUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessLogEntity extends ProcessLog {
	private String detailJsonStr;
	private String formattedTimestamp;

	/**
	 * <p>요청 조건에 맞는 데이터를 조회한다.</p>
	 * @return 처리 결과 문자열
	 */
	public String getDetailJsonStr() {
		return this.detailJsonStr;
	}

	/**
	 * <p>요청 조건에 맞는 데이터를 조회한다.</p>
	 * @return 처리 결과 문자열
	 */
	public String getFormattedTimestamp() {
		return this.formattedTimestamp;
	}

	/**
	 * <p>입력값으로 도메인 객체 또는 응답 객체를 생성한다.</p>
	 * @param processLog 처리에 사용할 입력값
	 * @return 처리된 ProcessLogEntity 객체
	 */
	public static ProcessLogEntity of(ProcessLog processLog) {
		ProcessLogEntity processLogEntity = new ProcessLogEntity();
		processLogEntity.setId(processLog.getId());
		processLogEntity.setAppName(processLog.getAppName());
		processLogEntity.setTimestamp(processLog.getTimestamp());
		processLogEntity.setMessage(processLog.getMessage());
		processLogEntity.setDetail(processLog.getDetail());
		processLogEntity.setDetailJsonStr(JsonUtils.toJSONPretty(processLog.getDetail()));
		processLogEntity.setFormattedTimestamp(
			processLog.getTimestamp()
				.atZone(ZoneId.of("Asia/Seoul"))
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		return processLogEntity;
	}
}
