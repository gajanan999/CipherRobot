package com.cipher.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * This class refers the table in the database
 * @author gajagaik
 *
 */
@Entity
@Table(name="dataentity")
@NamedQueries({ @NamedQuery(name = "findByText", query = "from DataEntity u where u.text= ?1") })
public class DataEntity {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name="text")
	private String text;
	
	@Column(name="key")
	private String key;
	
	@Column(name="algorithm")
	private String algorithm;
	
	@Column(name="userId")
	private String userName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	@Override
	public String toString() {
		return "DataEntity [id=" + id + ", text=" + text + ", key=" + key + ", algorithm=" + algorithm + ", userName="
				+ userName + "]";
	}
	
	
	
	
}
