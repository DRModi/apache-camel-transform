package com.learncamel.routes.gson;

import com.learncamel.bean.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class CamelMarshallingUsingGSONRoute extends RouteBuilder {


    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:inputGSONMarshallingJavaToJSON")
                .log(" >>>> before marshalling input value, Body is ${body}")
                .marshal(gsonDataFormat)
                .log(" >>>> After marshalling converted value, Body is ${body}");
    }
}
