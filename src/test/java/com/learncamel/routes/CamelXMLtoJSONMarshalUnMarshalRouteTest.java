package com.learncamel.routes;

import com.learncamel.routes.xml2json.CamelXMLtoJSONMarshalUnMarshalRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelXMLtoJSONMarshalUnMarshalRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new CamelXMLtoJSONMarshalUnMarshalRoute();
    }

    @Test
    public void marshalXMLtoJSONTest(){

        String inputValue = "<?xml version='1.0' encoding='UTF-8'?><employee><id>10666</id><name>DixitModi</name><joinedDate>03/01/2018</joinedDate></employee>";

        String outPutValue = template.requestBody("direct:inputXMLtoJSON",inputValue,String.class);

        String expectedValue = "{\"id\":\"10666\",\"name\":\"DixitModi\",\"joinedDate\":\"03/01/2018\"}";

        System.out.println(">>>> RESPONSE "+outPutValue);

        assertEquals(expectedValue,outPutValue);
    }

    @Test
    public void unMarshalJSONtoXMLTest(){

        //String expectedValue = "<?xml version='1.0' encoding='UTF-8'?>\r\n"+
          //      "<employee><id>10666</id><name>DixitModi</name><joinedDate>03/01/2018</joinedDate></employee>\r\n";

        String expectedValue ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><id>10666</id><joinedDate>03/01/2018</joinedDate><name>DixitModi</name></employee>\r\n";

        String inputValue = "{\"id\":\"10666\",\"name\":\"DixitModi\",\"joinedDate\":\"03/01/2018\"}";

        String outPutValue = template.requestBody("direct:inputJSONtoXML",inputValue,String.class);



        System.out.println(">>> RESPONSE "+outPutValue);

        assertEquals(expectedValue,outPutValue);
    }
}
