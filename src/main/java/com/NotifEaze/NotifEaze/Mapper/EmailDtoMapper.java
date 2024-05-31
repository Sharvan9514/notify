package com.NotifEaze.NotifEaze.Mapper;

import com.NotifEaze.NotifEaze.dto.BaseEmailResponse;

public class EmailDtoMapper {
    public static BaseEmailResponse resposeToEmailDto(String message, boolean status)
    {
        return new BaseEmailResponse(status, message);
    }
}
