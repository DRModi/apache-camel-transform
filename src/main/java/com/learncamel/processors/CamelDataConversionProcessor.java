package com.learncamel.processors;

import javafx.beans.property.ReadOnlyListProperty;
import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class CamelDataConversionProcessor implements org.apache.camel.Processor {


    public void process(Exchange exchange) throws Exception {

        System.out.println("Exchange in processor is :" + exchange.getIn().getBody());


        GenericFile<File> inputFile =  (GenericFile<File>) exchange.getIn().getBody();

        String readLine = null;
        String newValue = "";
        String outputText = "";

        if(inputFile!=null){
            FileReader retrieveFile = new FileReader(inputFile.getFile());
            BufferedReader reader = new BufferedReader(retrieveFile);


            while((readLine = reader.readLine())!=null){
                System.out.println("Read Line is : "+ readLine);
                String oldValue = readLine;
                newValue = newValue.concat(oldValue.replace(",",":")).concat("\n");

            }

            outputText = newValue.trim();
            exchange.getIn().setBody(outputText);
        }
    }
}
