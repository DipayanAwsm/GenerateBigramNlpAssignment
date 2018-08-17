/*
	Author:Dipayan
	Date:13-Apr-2018
	Year:2018
	Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
package com.dipayan.view;

public class ViewPages {
	
		/*here is the Uploading page where you upload the file*/
	public static String UPLOAD_LAND_PAGE="uploadJspPage/uploadPage";
	public static String SHOW_DATA_PAGE="show";
	public static final String HELLO = "hello";
	public static final String DIPAYAN = "cv/dipayan";
	public static final String SEARCH = "profile/search";
	public static final String STUDENT_DATA = "dataBase/student";
	public static final String DATABASE_ERROR_PAGE="dataBase/errorPage";
	public static final String STUDENT_CV_PAGE = "studentProfile/format5/studentData";
	public static final String SEARCH_STUDENT = "student/search";
	public static final String INSERT_STUDENT_DATA_HOME_PAGE = "student/insertStudentData";
	public static final String NLP_HOME_PAGE = "nlp/homePage";
	public static final String NLPDATA = "nlp/nlpData";
	
	/*	
		it returns the profile page of  that person
	*/
	public static String getResume(String profileName) {
		
		return "cv/"+profileName;
	}

}
