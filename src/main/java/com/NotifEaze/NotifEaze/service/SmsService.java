package com.NotifEaze.NotifEaze.service;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;
import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;

import javax.xml.bind.JAXBException;

public interface SmsService {
    BaseSmsResponse sendSms(String phoneNumber, String message) throws JAXBException;

    SmsDeliveryStatus checkDeliveryStatus(String messageId);
}
