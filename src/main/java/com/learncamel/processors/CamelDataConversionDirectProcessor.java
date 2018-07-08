package com.learncamel.processors;

import org.apache.camel.Exchange;

public class CamelDataConversionDirectProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        System.out.println("Processor: Retrieved message : "+exchange.getIn().getBody());

        String exchangeBody = (String) exchange.getIn().getBody();
        String conversionBody = exchangeBody.replace(",",":");
        exchange.getIn().setBody(conversionBody);
    }
}
