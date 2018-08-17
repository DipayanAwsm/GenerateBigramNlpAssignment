/*
========================================
	Author:Dipayan Das
	Roll:CS1726
	NLP Project
	Guide:Utpal G
	Bhabatu Sarba Mangalam
========================================	
*/
package com.dipayan.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dipayan.bean.DataBean;
import com.dipayan.bigram.CreateBigrm;
import com.dipayan.connection.CreateConnection;
import com.dipayan.constant.DataBaseConstant;
import com.dipayan.view.ViewPages;

@Controller
@RequestMapping("/nlp")
public class NLPController {
	String log="";
	static SessionFactory sessionfactory;
	static Session session;
	Criteria criteria;
	@RequestMapping(value="/homePage",method=RequestMethod.GET)	
	public String searchPage(ModelMap model) throws IOException {
			
		return ViewPages.NLP_HOME_PAGE;
	}
	@RequestMapping(value="/wordList",method=RequestMethod.GET)	
	public String WordLIst(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String requestData = request.getParameter("userName");
		if(requestData == null || "".equals(requestData)){
			requestData = "Guest";
		}
		
		String result = "Hello " + requestData;
		List<String> words=getListOfSuggestedWords(requestData);
		result=generateOutputString(words);
		response.setContentType("text/plain");
		response.getWriter().write(result);
		return result;	
	}
	
	/////////////////////////////
	@RequestMapping(value="/wordList",method=RequestMethod.POST)	
	public void WordListPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String requestData = request.getParameter("query");
		if(requestData == null || "".equals(requestData)){
			requestData = "Guest";
		}
		
		String result = "Hello " + requestData;
		List<String> words=getListOfSuggestedWords(requestData);
		result=generateOutputString(words);
		response.setContentType("text/plain");
		response.getWriter().write(result);
			
	}
	
	
	
	////////////////////////////
	
	
	

	private String generateOutputString(List<String> words) {
		String result="";
		if(null ==words) {
			return "";
		}
		result="<ul>";
		for(String temp:words) {
			result=result+"<li>"+temp+"</li>";
		}
		result=result+"</ul>";
		return result;
	}
	
	private List<String> getListOfSuggestedWords(String requestData) {

		List<String> result=null;
		//CreateBigrm database=new CreateBigrm();
		//<DataBean> reult=database.getSuggestiveWirds(requestData);
//		Criteria criteria=session.createCriteria(DataBean.class);
//		criteria.add(Restrictions.eq("firstWord",requestData));
//		
		/*List<DataBean> dataBean;
		DataBean data;
		dataBean=(List<DataBean>)criteria.list();
		if(null!=dataBean) {
			result=new ArrayList<String>();
			for(DataBean temp:dataBean) {
				result.add(temp.getSecondWord());
			}
		}
		closeConnection();*/
		result=getDataViaDataBase(requestData);
		return result;
	}
	private List<String> getDataViaDataBase(String requestData) {
		List<String> result=null;
		CreateConnection connection=null;
		try {
			connection= createConnection();
			Connection con=connection.getCon();
			Statement stmt=connection.getStatement();
			String query=createQuery(requestData);
			ResultSet rs=stmt.executeQuery(query);
			if(null!=rs) {
				result=new ArrayList<String>();
				while(rs.next()) {
					result.add(rs.getString(DataBaseConstant.TABLE_NLPASSIGNMENT_COLUMN_SECONDWORD));
					
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	private String createQuery(String requestData) {
		// TODO Auto-generated method stub
		
		return DataBaseConstant.SELECT_QUERY_FromNLPAssignment1+"'"+requestData+"'";
	}
	
	
	private CreateConnection createConnection() throws SQLException {
		 return new CreateConnection();
	}

		


	
}
