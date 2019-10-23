package main.db_files;

import main.config.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class CreateTables
{
//    public void createDatabase(){
//        Connection connection = new DatabaseConnection().getConnection();
//        String query = "CREATE DATABASE IF NOT EXISTS hospital";
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(query);
//        } catch (SQLException e) {
//            System.out.println("Unable to create a new database:"+ e.getMessage());
//        }
//        finally {
//            if (statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    System.out.println("Unable to close the sql statement:"+ e.getMessage());
//                }
//            }
//            System.out.println("Database 'hospital' created successfully");
//        }
//    }
//
//    public void executeCreateQuery(String query, String table_name){
//        Connection connection = new DatabaseConnection().getConnection();
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            statement.executeUpdate(query);
//            if (statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    System.out.println("Unable to close the sql statement:"+ e.getMessage());
//                }
//            }
//            System.out.println("Table " + table_name+ " created successfully");
//        } catch (SQLException e) {
//            System.out.println("Unable to create a new table:"+ e.getMessage());
//        }
//    }
//
//    public void createFacilityClassification(){
//        String query = "CREATE TABLE IF NOT EXISTS facility_classification("
//                +" classification_id NUMBER(10) NOT NULL,"
//                +" classification_type VARCHAR2(20) NOT NULL, "
//                +")";
//        this.executeCreateQuery(query,"facility_classification");
//    }
}