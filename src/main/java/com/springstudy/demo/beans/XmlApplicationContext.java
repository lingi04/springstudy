package com.springstudy.demo.beans;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlApplicationContext extends DefaultApplicationContext {

    private final BeanDefinitionReader beanDefinitionReader;

    public XmlApplicationContext(InputStream ins, BeanFactory parentBeanFactory){
        super(parentBeanFactory);

        beanDefinitionReader = new BeanDefinitionReader(this);

        registry(ins);
    }

    public XmlApplicationContext(InputStream ins){
        this(ins, null);
    }

    void registry(InputStream ins){
        Element element = null;

        try {
            element = parsingXmlInputStream(ins);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        doRegistry(element);

        refresh();
    }

    Element parsingXmlInputStream(InputStream ins) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(ins);
        Element element = document.getDocumentElement();

        return element;
    }

    void doRegistry(Element element){
        NodeList nodeList = element.getElementsByTagName("bean");

        for(int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            registerBeanDefinition((Element) n);
        }
    }

    void registerBeanDefinition(Element element){
        try {
            NodeList nodeList = element.getElementsByTagName("property");
            String id = element.getAttribute("id");

            Class clazz = Class.forName(element.getAttribute("class"));

            beanDefinitionReader.read(new BeanDefinition(id, getPropertyValues(nodeList), clazz));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private PropertyValues getPropertyValues(NodeList nodeList){
        List<PropertyValue> propertyValueList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element e = (Element) nodeList.item(i);

            propertyValueList.add(
                new PropertyValue(e.getAttribute("name"),
                    e.getAttribute("value")));
        }

        return new PropertyValues(propertyValueList);
    }

    public void refresh() {
        for (String beanName :
            getBeanDefinitionNames()) {
            getBean(beanName);
        }
    }

//    @Override
//    public int getBeanDefinitionCount() {
//        return super.beanDefinitionMap.size();
//    }
//
//    @Override
//    public String[] getBeanDefinitionNames() {
//        return super.beanDefinitionMap.keySet().toArray(String[]::new);
//    }
}
