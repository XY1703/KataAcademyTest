package com.ay.exception;

import com.ay.util.Message;
import com.ay.util.ServiceMessage;

public class WrongNumberException extends Exception{

    public Message getExceptionMessage(){
        return new Message(ServiceMessage.WRONG_NUMBER.getMessage());
    }
}
