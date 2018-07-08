package com.learncamel.routes;

import com.learncamel.routes.bean.CamelModifyFileBeanRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileBeanRouteTest extends CamelTestSupport {


    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyFileBeanRoute();

    }


    String expectedValue = "0505 & DixitModi & WorkHard\n" +
            "0211 & Aaradhy & GreatBoy\n" +
            "0708 & ArtiModi & GreatMom";

    String inputValue = "0505,DixitModi,WorkHard\n" +
            "0211,Aaradhy,GreatBoy\n" +
            "0708,ArtiModi,GreatMom";


    @Test
    public void beanRouteTest(){

        String outputValue = (String) template.requestBody("direct:inputBean",inputValue);
        File file = new File("data/outputBean");

        assertTrue(file.isDirectory());
        assertEquals(expectedValue,outputValue);
    }


    @Test
    public void beanRouteTestUsingMock(){

        MockEndpoint mock = getMockEndpoint("mock:outputBean");
        mock.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:inputBean",inputValue);

        try {

            assertMockEndpointsSatisfied();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void beanRouteTestUsingSecondMethod(){

        String outputValue = (String) template.requestBody("direct:inputBean",inputValue);

        File file = new File("data/outputBeanSecondMethod");

        assertTrue(file.isDirectory());

        assertEquals("0505 - DixitModi - WorkHard\n" +
                "0211 - Aaradhy - GreatBoy\n" +
                "0708 - ArtiModi - GreatMom",outputValue);
    }
}

