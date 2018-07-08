package com.learncamel.routes.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileTransformRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:inputForTransform")
                .log("Retrieved message body is ${body} and Headers are ${headers} from Direct Endpoint !!")
                .transform(body().regexReplaceAll(","," * "))
                .to("file:data/outputTransform?fileName=outputTransform.txt")
                .to("mock:outputTransform");
    }
}
