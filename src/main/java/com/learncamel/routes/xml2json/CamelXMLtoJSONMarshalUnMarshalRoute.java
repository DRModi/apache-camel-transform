package com.learncamel.routes.xml2json;

import com.learncamel.bean.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

import java.util.HashMap;
import java.util.Map;

public class CamelXMLtoJSONMarshalUnMarshalRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:inputXMLtoJSON")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true")
                .to("file:data/outputJSON?fileName=outputJson.txt");


        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("employee");


        from("direct:inputJSONtoXML")
                .to("log:?level=INFO&showBody=true")
                //.unmarshal().xmljson()
                .unmarshal(xmlJsonDataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("file:data/outputJSON?fileName=outputXML.txt");


    }
}
