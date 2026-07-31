package com.ljh.log.model;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "logs")
@Getter
@Setter
@ToString
public class ProcessLog {

	@Id
	private String id;

	@Field("app_name")
	private String appName;

	private Instant timestamp;

	private String message;

	private Object detail;
}
