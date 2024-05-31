package com.NotifEaze.NotifEaze.Mapper;

import com.NotifEaze.NotifEaze.dto.SmsDeliveryStatus;

public class SmsStatusDtoMapper {

    public static SmsDeliveryStatus responseToSmsStatusDto(boolean status, String message)
    {
        return new SmsDeliveryStatus(status, message);
    }
}
