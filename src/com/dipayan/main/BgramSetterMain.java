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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.dialect.spi.DatabaseMetaDataDialectResolutionInfoAdapter;

import com.dipayan.bean.DataBean;

public class BgramSetterMain {
	public static void main(String[] args) {
		
		DataBean data=new DataBean();
		data.setFirstWord("Hello");
		data.setSecondWord("World");
		data.setCount(1);
		SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		
		Criteria criteria=session.createCriteria(DataBean.class);
		criteria.add(Restrictions.eq("firstWord", data.getFirstWord()));
		criteria.add(Restrictions.eq("secondWord", data.getSecondWord()));
		
		List<DataBean> dataBean=(List<DataBean>)criteria.list();
		if(0==dataBean.size()) {
			session.save(data);
			//session.getTransaction().commit();
			session.save(data);
			session.clear();
		}else {
			dataBean.get(0).setCount(dataBean.get(0).getCount()+1);
			System.out.println(dataBean.get(0).getFirstWord()+"-"+dataBean.get(0).getSecondWord()+"-"+dataBean.get(0).getCount());
			//session.getTransaction().commit();
			session.update(dataBean.get(0));
			session.clear();
		}
		
		
		session.getTransaction().commit();
		session.close();
	}
	
	void readAndCreateCorpus() throws FileNotFoundException {
	    
		   
	}
	
}