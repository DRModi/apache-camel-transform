package com.learncamel.routes;

import com.learncamel.routes.transform.CamelModifyFileTransformRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileTransformRouteTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder(){
        return new CamelModifyFileTransformRoute();
    }


    String expectedValue = "123 * dixit * 03July2018\n" +
            "211 * aaradhy * 04July2018";

    String inputValue = "123,dixit,03July2018\n" +
            "211,aaradhy,04July2018";


    @Test
    public void dataCoversionUsingTransformTest(){

        String outputValue = (String) template.requestBody("direct:inputForTransform",inputValue);
        assertEquals(outputValue,expectedValue);

        File file = new File("data/outputTransform");
        assertTrue(file.isDirectory());

    }

    @Test
    public void dataConversionUsingTransformMockTest() throws InterruptedException {

        MockEndpoint mock = getMockEndpoint("mock:outputTransform");
        mock.expectedBodiesReceived(expectedValue);

        template.sendBody("direct:inputForTransform",inputValue);
        assertMockEndpointsSatisfied();

    }
}
