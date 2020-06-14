package com.caowei;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class XMLDemo {
    @Test
    public void saxParseXml() throws ParserConfigurationException, SAXException, IOException {
        //1、创建一个SAX解析器工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2、通过工厂对象创建SAX解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3、创建一个数据处理器（需要我们自己编写）
        PersonHandler personHandler = new PersonHandler();
        //4、开始解析
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/caowei/person.xml");
        saxParser.parse(is,personHandler);
        List<Person> persons = personHandler.getPersons();
        for(Person p:persons){
            System.out.println(p);
        }
    }
}
