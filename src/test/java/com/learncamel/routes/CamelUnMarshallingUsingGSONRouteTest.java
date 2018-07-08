package com.learncamel.routes;

import com.learncamel.bean.Employee;
import com.learncamel.routes.gson.CamelUnMarshallingUsingGSONRoute;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelUnMarshallingUsingGSONRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new CamelUnMarshallingUsingGSONRoute();
    }


    @Test
    public void gsonJSONtoJavaConverterTest(){

        String inputValue = "{\"id\":\"10666\",\"name\":\"Dixit Modi\",\"joinedDate\":\"03/01/2018\"}";

        Employee emp;

        emp = (Employee) template.requestBody("direct:inputJSONtoJava",inputValue);

        assertEquals("10666",emp.getId());
        assertEquals("Dixit Modi",emp.getName());
        assertEquals("03/01/2018",emp.getJoinedDate());

    }
}
