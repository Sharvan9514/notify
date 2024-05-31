package com.NotifEaze.NotifEaze.service;

import com.NotifEaze.NotifEaze.Mapper.EmailDtoMapper;
import com.NotifEaze.NotifEaze.Mapper.NotificationToDtoMapper;
import com.NotifEaze.NotifEaze.Mapper.SmsStatusDtoMapper;
import com.NotifEaze.NotifEaze.Mapper.SmsToDtoMapper;
import com.NotifEaze.NotifEaze.dto.*;
import com.NotifEaze.NotifEaze.mock.GupshupMock;
import com.NotifEaze.NotifEaze.mock.KayleraMock;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.function.Consumer;

@Service
@Slf4j
public class CommunicationService implements EmailService, PushNotificationService, SmsService{

    // Inject the mocks
    private final GupshupMock gupshupMock;
    private final KayleraMock kayleraMock;

    private final int x = 8;
    private final int y = 9;

    private int countRequest = 0;

    private boolean flag = true;


    public CommunicationService(GupshupMock gupshupMock, KayleraMock kayleraMock) {
        this.gupshupMock = gupshupMock;
        this.kayleraMock = kayleraMock;
    }


    @Override
    public BaseEmailResponse sendEmail(String to, String subject, String body) {
        // Using a comsumer to consume the message
        Consumer<String> consumer = message -> log.info("Message sent");
        consumer.accept(body);

        //Mocking the Email response
        String response = gupshupMock.mockEmailResponse();

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(response);// response will be the json String
        JsonEmailResponse emailResponse = gson.fromJson(object, JsonEmailResponse.class);
        if(response.contains("success"))
        {
            return EmailDtoMapper.resposeToEmailDto(emailResponse.getMessage(), true);

        }
        //converting the Response to DTO
        return EmailDtoMapper.resposeToEmailDto(response, false);

    }

    @Override
    public BasePushNotificationResponse sendNotification(String fcmToken, String message) {

        Consumer<String> consumer = notification -> log.info("Message sent");
        consumer.accept(message);

        String response = gupshupMock.mockPushNotification(fcmToken);

//        Gson gson = new Gson();
//        String json = gson.toJson(response);
        if(response.contains("success"))
        {
            return NotificationToDtoMapper.responseToNotificationDto(true, response);

        }

        return NotificationToDtoMapper.responseToNotificationDto(false, response);


    }

    @Override
    public BaseSmsResponse sendSms(String phoneNumber, String message) throws JAXBException {

        Consumer<String> consumer = notification -> log.info("Message sent");
        consumer.accept(message);
//        if(countRequest >=x)
//        {
//            flag = false;
//
//        }
//        countRequest++;

        String response = "";
//        if(flag)
//        {
//            response = gupshupMock.mockSmsResponse();
//        }
//        else {
            response = kayleraMock.getSmsResponse("123456");
            StringReader sr = new StringReader(response);
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            XmlSmsResponse xmlSmsResponse = (XmlSmsResponse) unmarshaller.unmarshal(sr);
            System.out.println(xmlSmsResponse);


        if(response.contains("true"))
        {
            return SmsToDtoMapper.responseToSmsDto(true, response);

        }

        return SmsToDtoMapper.responseToSmsDto(false, response);

    }

    @Override
    public SmsDeliveryStatus checkDeliveryStatus(String messageId) {
        String response = gupshupMock.mockSmsStatusResponse(messageId);
        if (response.contains("Success")) {
            return SmsStatusDtoMapper.responseToSmsStatusDto(true, response);
        }

        return SmsStatusDtoMapper.responseToSmsStatusDto(false, response);

    }

}
