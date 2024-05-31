package com.NotifEaze.NotifEaze.controller;

import com.NotifEaze.NotifEaze.Model.Email;
import com.NotifEaze.NotifEaze.Model.Notification;
import com.NotifEaze.NotifEaze.Model.Sms;
import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;
import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;
import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;
import com.NotifEaze.NotifEaze.service.CommunicationService;
import com.NotifEaze.NotifEaze.service.SmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping("/api/communication")
public class CommunicationController {

    private final CommunicationService communicationService;

    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @PostMapping("/send-sms")
    public ResponseEntity<BaseSmsResponse> sendSms(@RequestBody Sms sms) throws JAXBException {
        /* To be developed */

        BaseSmsResponse response = communicationService.sendSms(sms.getPhoneNumber(), sms.getMessage());
        if (response.isSuccess())
        {
            return ResponseEntity.ok().body(response);

        }
        return ResponseEntity.status(404).body(response);

    }

    @PostMapping("/send-email")
    public ResponseEntity<BaseEmailResponse> sendEmail(@RequestBody Email email) {
        /* To be developed */
        BaseEmailResponse response = communicationService.sendEmail(email.getTo(),email.getSubject(), email.getMessage());
        if (response.isSuccess())
        {
            return ResponseEntity.ok().body(response);

        }
        return ResponseEntity.status(404).body(response);
    }

    @PostMapping("/send-notification")
    public ResponseEntity<BasePushNotificationResponse> sendNotification(@RequestBody Notification notification) {
        /* To be developed */
        BasePushNotificationResponse response = communicationService.sendNotification(notification.getToken(), notification.getMessage());
        if(!response.isSuccess())
        {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.status(404).body(response);

    }

    @GetMapping("/sms-staus/{id}")
    public ResponseEntity<SmsDeliveryStatus> getSmsStatus(@PathVariable("id") String id)
    {
        SmsDeliveryStatus response = communicationService.checkDeliveryStatus(id);
        if(!response.isDelivered())
        {
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.status(404).body(response);
    }
}
