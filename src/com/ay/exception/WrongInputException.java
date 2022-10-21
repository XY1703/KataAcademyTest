package com.ay.exception;

import com.ay.util.Message;
import com.ay.util.ServiceMessage;

public class WrongInputException extends Exception{

    public Message getExceptionMessage(){
        return new Message(ServiceMessage.WRONG_INPUT.getMessage());
    }
}
