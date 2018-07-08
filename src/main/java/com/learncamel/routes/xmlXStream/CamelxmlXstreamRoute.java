package com.learncamel.routes.xmlXStream;

import com.learncamel.bean.Employee;
import com.learncamel.processors.CustomCSVtoXMLProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class CamelxmlXstreamRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("direct:csvInput")
                .process(new CustomCSVtoXMLProcessor())

                //Default xstream which will not have an aliases for Employee object and due to that, following will be used
                // in the generated XML as root element: <com.learncamel.bean.Employee> instead of <employee>
                // <?xml version='1.0' encoding='UTF-8'?>
                //  <com.learncamel.bean.Employee>
                // <id>10666</id><name>DixitModi</name><joinedDate>03/01/2018</joinedDate></com.learncamel.bean.Employee>


                //.marshal().xstream()
                .marshal(populateStreamDefination())
                .to("log:?level=INFO&showBody=true")
                .to("file:data/outputXstream?fileName=employee.xml")
                .to("mock:outputXstream");
    }


    private XStreamDataFormat populateStreamDefination(){

        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String,String> aliases = new HashMap<String, String>();
        aliases.put("employee",Employee.class.getName());

        xStreamDataFormat.setAliases(aliases);

        return xStreamDataFormat;

    }


}
