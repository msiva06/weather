package com.system.weather.exception;

public class ZipCodeNotFoundException extends  RuntimeException{

    public ZipCodeNotFoundException() {
        super();
    }

    public ZipCodeNotFoundException(String msg){
        super(msg);
    }


}
