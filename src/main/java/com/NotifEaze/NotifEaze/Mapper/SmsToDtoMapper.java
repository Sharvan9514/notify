package com.NotifEaze.NotifEaze.Mapper;

import com.NotifEaze.NotifEaze.dto.BaseSmsResponse;

public class SmsToDtoMapper {

    public static BaseSmsResponse responseToSmsDto(boolean status, String message)
    {
        return new BaseSmsResponse(status, message);
    }

}
