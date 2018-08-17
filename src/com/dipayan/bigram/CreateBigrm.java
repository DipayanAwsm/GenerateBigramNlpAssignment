/*
========================================
	Author:Dipayan Das
	Roll:CS1726
	NLP Project
	Guide:Utpal G
	Bhabatu Sarba Mangalam
========================================	
*/
package com.dipayan.bigram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.dipayan.bean.DataBean;

public class CreateBigrm {
	SessionFactory sessionfactory;
	Session session;
	Criteria criteria;
	public void createBigram(String fileLocation){
		
		/*pass the path to the file as a parameter*/
		
	    File file =   new File(fileLocation);
	    Scanner sc=null;
	    createConnecection();
		
	    try {
			sc= new Scanner(file);
			String tempData="";
		    String tempDataArray[];
		    int length;
//////////////////////////////////////////////////////
		    
		    
		    
		
			
			
	
		    /////////////////////////////////////////
		    while (sc.hasNextLine()) {
		    	tempData=sc.nextLine();
		    	tempData.trim();
		    	tempDataArray=tempData.split(" ");
		    	length=tempDataArray.length-1;
		    	String word1;
		    	String word2;
		    	for(int i=0;i<length;i++) {
		    		System.out.print(tempDataArray[i]+" "+tempDataArray[i+1]+"-\n");
		    		if(null!=tempDataArray[i] && null != tempDataArray[i+1]&& !" ".equals(tempDataArray)&& !" ".equals(tempDataArray[i+1])) {
		    			word1=tempDataArray[0].replaceAll("[^A-Za-z]","").toLowerCase();
		    			word2=tempDataArray[1].replaceAll("[^A-Za-z]","").toLowerCase();
		    			addOrUpdateTable(word1,word2);
		    			
		    		}
					
					
		    	}
		    	
		    }
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(null!=sc) {
				sc.close();
			}
			
		}
	    closeConnection();
	    
	}

	private void closeConnection() {
		if(null!=session) {
			session.getTransaction().commit();
			session.close();
		}
		
	}

	private void createConnecection() {
		sessionfactory=new Configuration().configure().buildSessionFactory();
		session=sessionfactory.openSession();
		session.beginTransaction();
		
		
	}

	public void addOrUpdateTable(String word1, String word2) {

	
		
		Criteria criteria=session.createCriteria(DataBean.class);
		criteria.add(Restrictions.eq("firstWord",word1));
		criteria.add(Restrictions.eq("secondWord", word2));
		List<DataBean> dataBean;
		DataBean data;
		dataBean=(List<DataBean>)criteria.list();
		

		if(0==dataBean.size()) {
			data=new DataBean();
			data.setFirstWord(word1);
			data.setSecondWord(word2);
			data.setCount(1);
			session.save(data);
			
			
		}else {
			dataBean.get(0).setCount(dataBean.get(0).getCount()+1);
			System.out.println(dataBean.get(0).getFirstWord()+"-"+dataBean.get(0).getSecondWord()+"-"+dataBean.get(0).getCount());
			//session.getTransaction().commit();
			session.update(dataBean.get(0));
			
			
		}
		
		
		
		
		
		
		
	}
}
