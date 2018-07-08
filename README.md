# learncamel - Important notes:


----------------

In Test:
The order does matter here because camel expects the Mockendpoint to be completely ready and built with the expected bodies
before connecting to the route.

    example:
    ********
    MockEndpoint mock = getMockEndpoint("mock:outputXstream");
    mock.expectedBodiesReceived(expectedValue1);
    template.sendBody("direct:csvInput",inputValue);

------------------

In Unmarshalling: to Java Object.

Required to set the permission on the object class while setting up the aliases in XStreamDataFormate, in order to resolve
below error:


Below error:
                com.thoughtworks.xstream.security.ForbiddenClassException: com.learncamel.bean.Employee
             	at com.thoughtworks.xstream.security.NoTypePermission.allows(NoTypePermission.java:

---------------

In Marshal: Marshiling to XML object

  //Default xstream which will not have an aliases for Employee object and due to that, following will be used
  // in the generated XML as root element: <com.learncamel.bean.Employee> instead of <employee>
  // <?xml version='1.0' encoding='UTF-8'?>
  //  <com.learncamel.bean.Employee>
  // <id>10666</id><name>DixitModi</name><joinedDate>03/01/2018</joinedDate></com.learncamel.bean.Employee>

   //.marshal().xstream()
   .marshal(populateStreamDefination())


---------------

In Unmarshaling - From JSON to XML, in order to set and

XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("employee");

--------------

Camel-gson library to Marshalling and Unmarshalling the JSON object


