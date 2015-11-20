package com.seostella.springautowire.domain;

import org.springframework.stereotype.Component;

/**
 *
 * @author seostella.com
 */
@Component
public class ConstructorService {
    
    public String doStuff(){
        return "ConstructorService.doStuff()";
    }
}
