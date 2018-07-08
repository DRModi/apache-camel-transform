package com.learncamel.routes.xmlXStream;

import com.learncamel.bean.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class CamelUnMarshalxmlXStreamRoute extends RouteBuilder {

    public void configure() throws Exception {


        Map<String,String> aliases = new HashMap<String, String>();
        aliases.put("employee",Employee.class.getName());
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class.getName());


        from("direct:xmlInput")
                .log("Received xmlBody is ${body}")
                .unmarshal(xStreamDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:outputUnmarshal");
    }
}
