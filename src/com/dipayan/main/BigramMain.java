/*
========================================
	Author:Dipayan Das
	Roll:CS1726
	NLP Project
	Guide:Utpal G
	Bhabatu Sarba Mangalam
========================================	
*/
package com.dipayan.main;

import com.dipayan.bigram.CreateBigrm;

public class BigramMain {
	public static void main(String[] args) {
		CreateBigrm createBigram=new CreateBigrm();
		if(args.length>0) {
			createBigram.createBigram(args[0]);
		}
		//createBigram.addOrUpdateTable("Dipayan", "Awsm");
	}
}
