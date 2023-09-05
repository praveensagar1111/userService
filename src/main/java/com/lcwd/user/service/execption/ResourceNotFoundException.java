package com.lcwd.user.service.execption;

public class ResourceNotFoundException extends  RuntimeException{
    //default message
    public ResourceNotFoundException (){
        super("Resource Not Found");

    }

    //this is you can add the exception
    public ResourceNotFoundException(String message){
        super(message);
    }
}
