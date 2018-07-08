package com.learncamel.routes.process;

import com.learncamel.processors.CamelDataConversionProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {


    public void configure() throws Exception {

        from("file:data/input?noop=true")
                .log("Read file Body is ${body} and Headers are ${headers}")
                .process(new CamelDataConversionProcessor())
                .to("file:data/output?fileName=output.txt")
                .to("mock:outputForTest");

    }
}
