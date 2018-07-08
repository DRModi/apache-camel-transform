package com.learncamel.routes.bean;

import com.learncamel.bean.CamelFileModifyBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileBeanRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("direct:inputBean")
                .log("Retrieved input before conversion body is : " + "\n" + "${body}")
                .bean(new CamelFileModifyBean(), "mapValue")
                .log("Converted output message body is : " + "\n" + "${body}")
                .to("file:data/outputBean?fileName=outputBean.txt")
                .to("mock:outputBean")
                .bean(new CamelFileModifyBean(), "mapValueSecondMethod")
                .log("Converted output message body after second method is : " + "\n" +"${body}")
                .to("file:data/outputBeanSecondMethod?fileName=outputBeanSecondMethod.txt");

    }
}
