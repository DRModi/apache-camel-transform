package com.learncamel.routes;

//import org.apache.camel.RoutesBuilder;
import com.learncamel.routes.process.CamelModifyFileProcessorRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelModifyFileProcessorRoute();
    }



    @Test
    public void processorDataConversionRouteTest() throws InterruptedException {

        String expectedValue = "0505:DixitModi:WorkHard\n" +
                "0211:Aaradhy:GreatBoy\n" +
                "0708:ArtiModi:GreatMom";

        MockEndpoint mock = getMockEndpoint("mock:outputForTest");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);
        File file = new File("data/output");


        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();

    }
}
