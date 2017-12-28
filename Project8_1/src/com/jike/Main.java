package com.jike;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class Main {

    public static void main(String[] args) {

        Resource r = new FileSystemResource("applicationContext.xml");
        BeanFactory f = new XmlBeanFactory(r);
        Employee employee = (Employee) f.getBean("employee");

        System.out.println(employee.contentOutput());
        
    }

}
