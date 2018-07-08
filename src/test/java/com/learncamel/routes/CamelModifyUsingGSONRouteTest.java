package com.learncamel.routes;

import com.learncamel.bean.Employee;
import com.learncamel.routes.gson.CamelMarshallingUsingGSONRoute;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyUsingGSONRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new CamelMarshallingUsingGSONRoute();
    }


    @Test
    public void GsonJavaToJSONConversionTest(){

        Employee employee = new Employee();
        employee.setId("10666");
        employee.setName("Dixit Modi");
        employee.setJoinedDate("03/01/2018");

        String expectedValue = "{\"id\":\"10666\",\"name\":\"Dixit Modi\",\"joinedDate\":\"03/01/2018\"}";

        String outputValue = template.requestBody("direct:inputGSONMarshallingJavaToJSON",employee,String.class);

        System.out.println( "OutputValue : "+outputValue);

        assertEquals(expectedValue,outputValue);
    }
}
