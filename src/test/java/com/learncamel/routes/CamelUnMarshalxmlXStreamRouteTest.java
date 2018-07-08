package com.learncamel.routes;

import com.learncamel.bean.Employee;
import com.learncamel.routes.xmlXStream.CamelUnMarshalxmlXStreamRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelUnMarshalxmlXStreamRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder(){
        return new CamelUnMarshalxmlXStreamRoute();
    }


    @Test
    public void camelUnmarshalXstreamTest(){

        Employee employee = new Employee();
        employee.setId("10666");
        employee.setName("DixitModi");
        employee.setJoinedDate("03/01/2018");

        String xmlInput = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<employee>" +
                "<id>10666</id>" +
                "<name>DixitModi</name>" +
                "<joinedDate>03/01/2018</joinedDate>" +
                "</employee>";

        System.out.println("\n"+">>>>>> SOUT >>>>"+employee.toString()+"\n");

        MockEndpoint mock = getMockEndpoint("mock:outputUnmarshal");
        mock.expectedBodiesReceived(employee.toString());
        template.sendBody("direct:xmlInput",xmlInput);

        try {
            assertMockEndpointsSatisfied();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
