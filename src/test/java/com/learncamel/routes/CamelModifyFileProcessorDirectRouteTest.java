package com.learncamel.routes;

import com.learncamel.routes.process.CamelModifyFileProcessorDirectRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;


public class CamelModifyFileProcessorDirectRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() {
        return new CamelModifyFileProcessorDirectRoute();
    }

    String expectedValue = "123:dixit:03July2018\n" +
            "211:aaradhy:04July2018";

    String inputValue = "123,dixit,03July2018\n" +
            "211,aaradhy,04July2018";

    @Test
    public void fileConversionDirectTest() {
        String outputValue = (String) template.requestBody("direct:processorInput", inputValue);
        assertEquals(expectedValue, outputValue);

        File file = new File("data/outputDirect");
        assertTrue(file.isDirectory());
    }

    @Test
    public void fileConversionDirectMockTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:outputDirect");
        mock.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:processorInput", inputValue);
        assertMockEndpointsSatisfied();

    }
}
