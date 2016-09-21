/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class connect {
    protected Connection con;
    public void getConnect() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public void getClose() throws SQLException{
        con.close();
    }
}
//public static void main(String[] argv) {
//
//	System.out.println("-------- MySQL JDBC Connection Testing ------------");
//
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//	} catch (ClassNotFoundException e) {
//		System.out.println("Where is your MySQL JDBC Driver?");
//		e.printStackTrace();
//		return;
//	}
//
//	System.out.println("MySQL JDBC Driver Registered!");
//	Connection connection = null;
//
//	try {
//		connection = DriverManager
//		.getConnection("jdbc:mysql://localhost:3306/mydb","root", "");
//
//	} catch (SQLException e) {
//		System.out.println("Connection Failed! Check output console");
//		e.printStackTrace();
//		return;
//	}
//
//	if (connection != null) {
//		System.out.println("You made it, take control your database now!");
//	} else {
//		System.out.println("Failed to make connection!");
//	}
//  }