package com.szmolke.coderslab.submissions.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DbUtil {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    public static LocalDateTime getLocalDateTime(ResultSet resultSet, String columnName) throws SQLException {
        final Timestamp timestamp = resultSet.getTimestamp(columnName);
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

    private static DataSource getInstance() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:/comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/submissions");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }
}