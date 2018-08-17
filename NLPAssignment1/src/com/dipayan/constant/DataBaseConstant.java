package com.dipayan.constant;

/*Here is the configuration of database is user password etc*/
public class DataBaseConstant {
	// "jdbc:mysql://localhost:3306/db_dipayan","dipayandas","dipayan"
	/*User Name which contaions thr ip and port  here localhost*/
	public static final String USER="localhost";
	
	public static final String PORT="3306";
	/*DataBase its Using*/
	public static final String DB="db_dipayan";
	/*UserName for authentication for username password*/
	public static final String USER_NAME="dipayandas";
	public static final String PASSWORD="dipayan";
	
	/*Connection Bean Name its the  id in xml file connectionBean.xml*/
	public static final String CONNECTION_BEAN_NAME="connectionDataBase";
	
	/*Select query based on roll number*/
	public static final String SELECT_QUERY_FromSTUDENT_ON_ROLL = "select * from student where rollNumber=" ;

	public static final String SELECT_QUERY_FromSTUDENT_INSTITUTE_ON_ROLL = "select * from student_institute where student_rollNumber=";

	public static final String NO_SUCH_DATA_EXIST = "No Such Student Exist";

	
	
	public static final String NO_STUDENT_INSTITUTE_DATA_EXIST = "No Institute data is registered";


	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_ROLLNUMBER  = "rollNumber";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_NAME   = "name";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_PASSWORD  = "password";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_ADDRESS  = "address";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_EMAIL  = "email";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_DOB   = "DOB";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_ABOUT  = "about";
	
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_PHONENUMBER = "phoneNumber";
	/*Columns in TABLE_STUDENT */
	public static final String TABLE_STUDENT_COLUMN_PICID  = "picID";
	
	/*Columns in TABLE_INSTITUTE */
	public static final String TABLE_INSTITUTE_COLUMN_ID   = "id";
	/*Columns in TABLE_INSTITUTE */
	public static final String TABLE_INSTITUTE_COLUMN_NAME   = "name";
	/*Columns in TABLE_INSTITUTE */
	public static final String TABLE_INSTITUTE_COLUMN_LOCATION   = "location";
	
	
	
	
	
	
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_STUDENT_ROLL = "student_rollNumber";
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_INSTITUTE_ID ="institute_id";
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_AWARDS ="awards";
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_DEPARTMENT="department";
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_YEAR_OF_PASSING="year_of_passing";
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_INSTITUTE_NAME="institute_name";
	/*Columns in TABLE_STUDENT_INSTITUTE */
	public static final String TABLE_STUDENT_INSTITUTE_COLUMN_MARKS="marks";

	public static final String CONNECTION_CAN_BE_ESTABLISH = "Connection cant be establish please chech the id port database username password and other settings";

	public static final String SELECT_QUERY_FromOnINSTITUTE_ON_IDLIST = "select * from institute where id in";

	public static final String SELECT_QUERY_FromNLPAssignment1 = "select * from NLPAssignment where first_Word=";

	public static final String TABLE_NLPASSIGNMENT_COLUMN_SECONDWORD = "second_Word";
	
	
}
