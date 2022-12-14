package com.ay;

import com.ay.exception.WrongInputException;
import com.ay.exception.WrongNumberException;
import com.ay.util.Message;
import com.ay.util.MessageHandler;
import com.ay.util.MessageParser;
import com.ay.util.ServiceMessage;

import java.io.IOException;
import java.util.Map;

public class Calculator {

    public void start() throws IOException {

        MessageHandler.printMessage(new Message(ServiceMessage.HELLO_MESSAGE.getMessage()));

        while (true){
            Message message = MessageHandler.getMessage();

            try {
                Map<String, String[]> input = MessageParser.parseMessage(message);
                for(Map.Entry<String, String[]> stringEntry : input.entrySet()){
                    if(MessageParser.isOnlyRomeNumbers(message.getMessage())){
                        System.out.println(MessageParser.arabicToRoman(doAction(Integer.parseInt(stringEntry.getValue()[0]),
                                Integer.parseInt(stringEntry.getValue()[1]), stringEntry.getKey())));
                    }else if(MessageParser.isOnlyArabicNumbers(message.getMessage())){
                        input.forEach((k, v) -> System.out.println(doAction(Integer.parseInt(v[0]), Integer.parseInt(v[1]), k)));
                    }
                }
            } catch (WrongInputException e) {
                MessageHandler.printMessage(e.getExceptionMessage());
                break;
            } catch (WrongNumberException e) {
                MessageHandler.printMessage(e.getExceptionMessage());
                break;
            }

        }
    }

    public int doAction(int a, int b, String sign){
        switch (sign){
            case ("+"):
                return a + b;
            case ("-"):
                return a - b;
            case ("/"):
                return a / b;
            case ("*"):
                return a * b;
            default:
        }return 0;
    }
}
