package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import java.text.ParseException;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void displayDate() {
    // Load the XML configuration
    ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

    // Retrieve the SimpleDateFormat bean
    SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

    try {
        // Parse string date to Date object
        Date date = format.parse("31/12/2018");

        // Display the result
        System.out.println(date);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    // Close the context to free resources
    ((ClassPathXmlApplicationContext) context).close();
}

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("Inside main method");

        displayDate();
    }

}
