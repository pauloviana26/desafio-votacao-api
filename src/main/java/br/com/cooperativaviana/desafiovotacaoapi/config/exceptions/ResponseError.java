package br.com.cooperativaviana.desafiovotacaoapi.config.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ResponseError {
	
	private int code;
	private String description;
	private Map<String, String> fields = new HashMap<>();
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, String> getFields() {
		return fields;
	}
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

}
