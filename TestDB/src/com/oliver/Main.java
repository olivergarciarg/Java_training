package com.oliver;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\005_Java_training\\TestDB\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\005_Java_training\\TestDB\\testjava.db");
//            Statement statement = conn.createStatement();) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " TEXT)");
            insertContact(statement, "tim1", 1234561, "tim1@tim.com");
            insertContact(statement, "tim2", 1234562, "tim2@tim.com");
            insertContact(statement, "tim3", 1234563, "tim3@tim.com");
            insertContact(statement, "tim4", 1234564, "tim4@tim.com");

//            statement.execute("INSERT INTO " + TABLE_CONTACTS
//                    + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL
//                    + ") VALUES ('tim1', 1234561, 'tim1@tim.com')");
//            statement.execute("INSERT INTO " + TABLE_CONTACTS
//                    + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL
//                    + ") VALUES ('tim2', 1234562, 'tim2@tim.com')");
//            statement.execute("INSERT INTO " + TABLE_CONTACTS
//                    + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL
//                    + ") VALUES ('tim3', 1234563, 'tim3@tim.com')");
//            statement.execute("INSERT INTO " + TABLE_CONTACTS
//                    + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL
//                    + ") VALUES ('tim4', 1234564, 'tim4@tim.com')");

            statement.execute("UPDATE " + TABLE_CONTACTS +
                    " SET " + COLUMN_PHONE + "=789456 WHERE " + COLUMN_NAME + "='tim4'");
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='tim3'");
//            statement.execute("SELECT * FROM contacts");
//            ResultSet resultSet = statement.getResultSet();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while(resultSet.next()) {
                System.out.println(resultSet.getString(COLUMN_NAME) + " " +
                                    resultSet.getString(COLUMN_PHONE) + " " +
                                    resultSet.getString(COLUMN_EMAIL));
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("crash " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute(
                "INSERT INTO " + TABLE_CONTACTS
                + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL
                + ") VALUES ('" +
                name + "','" + phone + "','" + email + "')"
        );
    }
}