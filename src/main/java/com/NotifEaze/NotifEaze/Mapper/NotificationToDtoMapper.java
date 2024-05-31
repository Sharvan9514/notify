package com.NotifEaze.NotifEaze.Mapper;

import com.NotifEaze.NotifEaze.dto.BasePushNotificationResponse;

public class NotificationToDtoMapper {

    public static BasePushNotificationResponse responseToNotificationDto(boolean status, String message)
    {
        return new BasePushNotificationResponse(status, message);
    }
}
