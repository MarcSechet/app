package com.marc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class JdbcUtils {
    private static Connection getConnection2() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }


    public static BasicDataSource dataSource() throws URISyntaxException {
        String dbUrl2 = "jdbc:postgresql://"
                +"ec2-54-75-230-41.eu-west-1.compute.amazonaws.com:"
                +"5432"
                + "/"
                +"d7rb1ijimfr0td?ssl=true&sslmode=require";


        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl2);
        basicDataSource.setUsername("blydvtuttrdvts");
        basicDataSource.setPassword("d1b2ea22a834fa2d900e879440e13d4b9229210008acb0544cb0d07a3bb4a4cd");
        return basicDataSource;
    }



}
