package com.example.chatboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@SpringBootTest
public class test {
    @Autowired
    DataSource dataSource;

    @Test
    public void conntetion() throws SQLException {
        try(Connection con = dataSource.getConnection()) {
            DatabaseMetaData metaData = con.getMetaData();
            System.out.println("URL: "  + metaData.getURL());
            System.out.println("DriverName: " + metaData.getDriverName());
            System.out.println("UserName : " + metaData.getUserName());
        }
    }
}
