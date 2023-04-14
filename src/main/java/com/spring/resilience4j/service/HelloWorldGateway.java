package com.spring.resilience4j.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Slf4j
@Service
@RequiredArgsConstructor
public class HelloWorldGateway {
    private final RestTemplate restTemplate ;

    public static final String ACCOUNT_SID = "AC5ac97cafc20c9b48ef441f76a18ac642";
    public static final String AUTH_TOKEN = "79711143acd1eff00f777415d83b6bc4";
    public static final String FROM_PHONE_NUMBER = "+18337920609";
    public static final String TO_PHONE_NUMBER = "+14695249207";
    int counter = 0;
    public String getHelloWorld() {
        log.info("calling getHelloWorld()  " + counter++);
        return restTemplate.getForObject("/world", String.class);
    }

    public String generateOTP() {
        log.info("calling generateOTP()  " + counter++);
        return restTemplate.getForObject("/world", String.class);
    }
    public String sendSMS() {
        log.info("calling sendSMS()  " + counter++);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber(TO_PHONE_NUMBER),
                        new PhoneNumber(FROM_PHONE_NUMBER),
                        "Hey Naveen Kumar Bandela whatsapp!")
                .create();

        System.out.println("SMS sent. Message SID: " + message.getSid());
        return message.toString();
    }
}
