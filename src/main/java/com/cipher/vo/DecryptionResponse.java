package com.cipher.vo;

public class DecryptionResponse {
	private String encryptedText;
	private String decryptedText;
	private String status;
	private String message;
	
	public String getEncryptedText() {
		return encryptedText;
	}
	public void setEncryptedText(String encryptedText) {
		this.encryptedText = encryptedText;
	}
	public String getDecryptedText() {
		return decryptedText;
	}
	public void setDecryptedText(String decryptedText) {
		this.decryptedText = decryptedText;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
