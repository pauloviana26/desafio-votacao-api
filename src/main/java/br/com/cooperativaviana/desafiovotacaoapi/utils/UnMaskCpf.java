package br.com.cooperativaviana.desafiovotacaoapi.utils;

import org.apache.commons.lang3.StringUtils;

public class UnMaskCpf {
	
	public static String unMask(String value) {
		if (StringUtils.isEmpty(value)) return value;
		return value.replaceAll("\\D+", "");
	}

}
