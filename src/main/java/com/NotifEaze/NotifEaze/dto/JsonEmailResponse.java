package com.NotifEaze.NotifEaze.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonEmailResponse {
    private String status;
    private String message;
    private String timestamp;
}
