/*
========================================
	Author:Dipayan Das
	Roll:CS1726
	NLP Project
	Guide:Utpal G
	Bhabatu Sarba Mangalam
========================================	
*/
package com.dipayan.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "NLPAssignment")
public class DataBean implements Serializable{
	
	@Id
	@Column(name = "first_Word")
	private String firstWord;
	
	@Id
	@Column(name = "second_Word")
	private String secondWord;
	
	@Column(name = "count")
	int count;

	public String getFirstWord() {
		return firstWord;
	}

	public void setFirstWord(String firstWord) {
	this.firstWord = firstWord;}

	public String getSecondWord() {
		return secondWord;
	}

	public void setSecondWord(String secondWord) {
	this.secondWord = secondWord;}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
	this.count = count;}
	
	
	
	

}
