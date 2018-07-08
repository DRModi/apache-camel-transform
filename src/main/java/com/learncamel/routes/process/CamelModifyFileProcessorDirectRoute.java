package com.learncamel.routes.process;

import com.learncamel.processors.CamelDataConversionDirectProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorDirectRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("direct:processorInput")
                .log("Retrieved message body is ${body} and Headers are ${headers}")
                .process(new CamelDataConversionDirectProcessor())
                .log("After processing from processor - Body is ${body} and Headers are ${headers}")
                .to("file:data/outputDirect?fileName=outputDirect.txt")
                .to("mock:outputDirect");
    }
}
