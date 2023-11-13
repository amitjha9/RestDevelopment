package com.practice.utils;

import com.practice.base.TestBase;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtility {

    public static Connection connection = null;
    public static Properties properties;
    public static ResultSet resultSet;
    public static Connection createConnection(String dbURL,String userName, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbURL, userName, password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
            System.exit(0);
        }
        //System.out.println("DB Connected");
        return connection;
    }

    public static ResultSet selectQueryInPBPCollection(String dbURL,String userName, String password,String collectionName) throws SQLException {

        System.out.println("Query in PBP Collection");
        String sqlQuery = "select * from "+collectionName+" where product_code = 'MTA-49227644'";
        try {
            connection=createConnection(dbURL,userName,password);
            if(connection!=null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Please check : Error while connecting Database");
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
        }
        finally {
            if(connection!=null)
            {
                connection.close();
            }
        }
        return resultSet;
    }

    public static ResultSet selectQueryInPCBCollection(String dbURL,String userName, String password,String collectionName) throws SQLException {
        System.out.println("Query in PCB Collection");
        String sqlQuery = "select * from "+collectionName+" where product_code = 'MTA-49227644'";
        try {
            connection=createConnection(dbURL,userName,password);
            if(connection!=null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Please check : Error while connecting Database");
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
        }
        finally {
            if(connection!=null)
            {
                connection.close();
            }
        }
        return resultSet;
    }

    public static ResultSet selectQueryInPDTCollection(String dbURL,String userName, String password,String collectionName) throws SQLException {
        System.out.println("Query in PDT Collection");
        String sqlQuery = "select * from "+collectionName+" where product_code = 'MTA-49227644'";
        try {
            connection=createConnection(dbURL,userName,password);
            if(connection!=null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Please check : Error while connecting Database");
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
        }
        finally {
            if(connection!=null)
            {
                connection.close();
            }
        }
        return resultSet;
    }


    public static ResultSet selectQueryInBulkCollection(String dbURL,String userName, String password,String collectionName) throws SQLException {
        System.out.println("Query in X-BULK Collection");
        String sqlQuery = "select * from "+collectionName+" ORDER by created_date DESC LIMIT 1";
        try {
            connection=createConnection(dbURL,userName,password);
            if(connection!=null)
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                resultSet = preparedStatement.executeQuery();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Please check : Error while connecting Database");
            System.err.println(e.getClass().getName()+ ":" +e.getMessage());
        }
        finally {
            if(connection!=null)
            {
                connection.close();
            }
        }
        return resultSet;
    }

    public static void main(String[] args) throws SQLException {
        properties = TestBase.dbConfig();
        selectQueryInBulkCollection(properties.getProperty("spring.datasource.url.bulk"),properties.getProperty("spring.datasource.username.bulk"),properties.getProperty("spring.datasource.password.bulk"),properties.getProperty("bulk.collection.name"));
    }
}
