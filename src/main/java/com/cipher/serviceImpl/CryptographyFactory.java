package com.cipher.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.config.Messages;
import com.cipher.service.CryptographyService;

@Service
public class CryptographyFactory {
	@Autowired
	Messages messages;

	private static final Map<String, CryptographyService> serviceCache = new HashMap<>();

	@Autowired
	public void initMyServiceCache(List<CryptographyService> services) {
		for (CryptographyService service : services) {
			serviceCache.put(service.getType(), service);
		}
	}

	public CryptographyService getService(String type) {
		CryptographyService service = serviceCache.get(type);
		if (service == null)
			throw new RuntimeException(messages.get("UNKNOWN_ALGORITHM") + type);
		return service;
	}
}
