package com.springautowire;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;

import com.springautowire.domain.*;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author seostella.com
 */
public class AutowireTest {

    private int lineNumber = 1;
    private ApplicationContext context;

    public AutowireTest(ApplicationContext context) {
        this.context = context;
    }

    public void testAutowire( JspWriter jspWriter ) {
        BeanContainer beenContainer = (BeanContainer) context.getBean(BeanContainer.class);
        print( jspWriter, " == @Autowire class field");
        FieldService propertyService = beenContainer.getPropertyService();
        print( jspWriter, propertyService.doStuff(), true);
        
        print( jspWriter, " == @Autowire setter");
        SetterService setterService = beenContainer.getSetterService();
        print( jspWriter, setterService.doStuff(), true );
        
        print( jspWriter, " == @Autowire constructor");
        ConstructorService constructorService = beenContainer.getConstructorService();
        print( jspWriter, constructorService.doStuff(), true );
        
        print( jspWriter, " == @Autowire method");
        SetterAService setterAService = beenContainer.getSetterAService();
        SetterBService setterBService = beenContainer.getSetterBService();
        print( jspWriter, setterAService.doStuff(), true );
        print( jspWriter, setterBService.doStuff(), true );
        
        print( jspWriter, " == @Autowire applicationContext");
        AppcontextService acService = beenContainer.getAcService();
        print( jspWriter, acService.doStuff(), true );
        
        print( jspWriter, " == @Autowire and require=false");
        NotBeanService notBeanService = beenContainer.getNotBeanService();
        if( notBeanService != null ){
            print( jspWriter, notBeanService.doStuff(), true );
        } else {
            print( jspWriter, "notBeanService=null", true );
        }
        
        print( jspWriter, " == @Autowire @Qualifier");
        FooService fooService = beenContainer.getFooService();
        print( jspWriter, fooService.doStuff(), true );
    }
    
    private void print( JspWriter jspWriter, String str ){
        print( jspWriter, str, false );
    }
    
    private void print( JspWriter jspWriter, String str, boolean showNumber ){
        try {
            String numberString = showNumber ? "<b>" + (lineNumber++) + ": </b>" : "";
            jspWriter.write("<p>" + numberString + str + "</p>");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}
