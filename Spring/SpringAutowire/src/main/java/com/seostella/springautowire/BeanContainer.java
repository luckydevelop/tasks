package com.seostella.springautowire;

import com.seostella.springautowire.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author seostella.com
 */
@Component
public class BeanContainer {
    // ***** method property *****
    @Autowired
    private FieldService propertyService;

    public FieldService getPropertyService() {
        return this.propertyService;
    }
    // ***** setter *****
    private SetterService setterService;

    @Autowired
    public void setSetterService(SetterService setterService) {
        this.setterService = setterService;
    }

    public SetterService getSetterService() {
        return setterService;
    }
    // ***** method *****
    private SetterAService setterAService;
    private SetterBService setterBService;

    @Autowired
    public void multipleArguments(SetterAService setterAService,
            SetterBService setterBService) {
        this.setterAService = setterAService;
        this.setterBService = setterBService;
    }

    public SetterAService getSetterAService() {
        return setterAService;
    }

    public SetterBService getSetterBService() {
        return setterBService;
    }

    // ***** constructor *****
    private ConstructorService constructorService;
    
    @Autowired
    public BeanContainer(ConstructorService constructorService) {
        this.constructorService = constructorService;
    }

    public ConstructorService getConstructorService() {
        return constructorService;
    }
    
    // ***** required=false *****
    @Autowired(required=false)
    private NotBeanService notBeanService;

    public NotBeanService getNotBeanService() {
        return notBeanService;
    }
    
    // ***** from applicationContext xml *****
    @Autowired
    private AppcontextService acService;

    public AppcontextService getAcService() {
        return acService;
    }
    
    // ***** @Qualifier *****
    @Autowired
    @Qualifier("fooService2")
    private FooService fooService;

    public FooService getFooService() {
        return fooService;
    }
    
}
