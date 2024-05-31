package com.NotifEaze.NotifEaze.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sms {
    String phoneNumber;
    String message;
}
