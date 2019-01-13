package com.marc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    Map<String, String> mainHello() {
        System.out.println("mainhello");
        ResultSet toDisplay;
        String toReturn = "";
        try {
            toDisplay = JdbcUtils.dataSource()
                    .getConnection()
                    .prepareStatement("Select * from users")
                    .executeQuery();
            while (toDisplay.next()) {
                toReturn+=toDisplay.getString("username");
            }
            return Collections.singletonMap("response", toReturn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return Collections.singletonMap("response", "Hello home page!");
    }
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
