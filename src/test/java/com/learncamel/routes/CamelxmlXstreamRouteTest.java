package com.learncamel.routes;

import com.learncamel.routes.xmlXStream.CamelxmlXstreamRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelxmlXstreamRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelxmlXstreamRoute();
    }


    String inputValue = "10666,DixitModi,03/01/2018";

    String expectedValue = "<?xml version='1.0' encoding='UTF-8'?>" +
            "<com.learncamel.bean.Employee>" +
            "<id>10666</id><name>DixitModi" +
            "</name><joinedDate>03/01/2018</joinedDate>" +
            "</com.learncamel.bean.Employee>";


    String expectedValue1 = "<?xml version='1.0' encoding='UTF-8'?>" +
            "<employee>" +
            "<id>10666</id><name>DixitModi" +
            "</name><joinedDate>03/01/2018</joinedDate>" +
            "</employee>";

    @Test
    public void xmlMarshalXstreamTest(){

        template.sendBody("direct:csvInput",inputValue);

        File file = new File("data/outputXstream");

        assertTrue(file.isDirectory());


    }

    @Test
    public void xmlMarshalXstreamTestUsingMockEndPoin() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:outputXstream");
        mock.expectedBodiesReceived(expectedValue1);
        template.sendBody("direct:csvInput",inputValue);

        assertMockEndpointsSatisfied();

    }
}
