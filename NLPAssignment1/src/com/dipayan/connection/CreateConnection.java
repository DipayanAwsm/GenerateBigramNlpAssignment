package com.dipayan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.dipayan.constant.DataBaseConstant;

/*Author:Dipayans
Date:19-Apr-2018
Year:2018
Be Happy , Do what you need to, Do Remember Action Cures Fear
*/
/*This is used to create Connectionwith DataBAse*/
public class CreateConnection {
	private String connectionLink = null;
	private Connection conection;
	private Statement statement;

	public Connection getCon() {
		return this.conection;
	}

	public void setCon(Connection conection) {
		this.conection = conection;
	}

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public CreateConnection() throws SQLException {
		createConnectionLink();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Connection
			// con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_dipayan","dipayandas","dipayan");
			this.conection = DriverManager.getConnection(this.connectionLink, DataBaseConstant.USER_NAME,
					DataBaseConstant.PASSWORD);
			// here sonoo is the database name, root is the username and root is the
			// password
			this.statement = this.conection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* Creating the cnnection Link */
	private void createConnectionLink() {
		this.connectionLink = "jdbc:mysql://" + DataBaseConstant.USER + ":" + DataBaseConstant.PORT + "/"
				+ DataBaseConstant.DB;
	}

	public void closeConnection() throws SQLException {

		try {
			if (null != this.conection || !this.conection.isClosed()) {
				this.conection.close();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
