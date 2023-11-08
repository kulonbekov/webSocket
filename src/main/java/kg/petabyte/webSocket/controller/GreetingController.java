package kg.petabyte.webSocket.controller;

import kg.petabyte.webSocket.entities.Greeting;
import kg.petabyte.webSocket.entities.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception{

        Thread.sleep(2000); //симуляционная задержка

        return new Greeting("Hello, " + message.getName() + "!");
    }
}
