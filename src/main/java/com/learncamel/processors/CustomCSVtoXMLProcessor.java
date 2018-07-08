package com.learncamel.processors;

import com.learncamel.bean.Employee;
import org.apache.camel.Exchange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class CustomCSVtoXMLProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        String newBody = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(newBody,",");

        Employee employee = new Employee();

        while (tokenizer.hasMoreElements()){

            employee.setId((String) tokenizer.nextElement());
            employee.setName((String) tokenizer.nextElement());
            employee.setJoinedDate((String) ((String) tokenizer.nextElement()));
        }

        exchange.getIn().setBody(employee);

    }
}
