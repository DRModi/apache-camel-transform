package com.learncamel.routes.gson;

import com.learncamel.bean.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class CamelUnMarshallingUsingGSONRoute extends RouteBuilder {




    public void configure() throws Exception {


        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:inputJSONtoJava")
                .log("Received input before conversion and body is ${body}")
                .unmarshal(gsonDataFormat)
                .log("After conversion and body is ${body}");

    }
}
