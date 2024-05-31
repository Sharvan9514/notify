package com.NotifEaze.NotifEaze.mock;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class GupshupMock {
    private static final Map<String, String> SMS_MOCKED_RESPONSES = new HashMap<>();
    private static final Map<String, String> EMAIL_MOCKED_RESPONSES = new HashMap<>();

    private static final Map<String, String> SMS_DELIVERY_STATUS_MOCKED_RESPONSES = new HashMap<>();

    private static final Map<String, String> PN_MOCKED_RESPONSES = new HashMap<>();

    public String mockEmailResponse()
    {
        return EMAIL_MOCKED_RESPONSES.get("Email1");
    }

    public String mockPushNotification(String token)
    {
        return PN_MOCKED_RESPONSES.get(token);
    }

    public String mockSmsResponse()
    {
        return SMS_MOCKED_RESPONSES.get("MessageId1");
    }

    public String mockSmsStatusResponse(String messageId)
    {
        return SMS_DELIVERY_STATUS_MOCKED_RESPONSES.get(messageId);
    }




    static {

        /*
        {
          "success": true,
          "messageId": "MessageId1",
          "providerResponse": "SMSsentsuccessfully."
        }
         */
        SMS_MOCKED_RESPONSES.put("MessageId1", "{\"success\":true,\"messageId\":\"MessageId1\",\"providerResponse\":\"SMSsentsuccessfully.\"}");

        /*
        {
          "success": false,
          "messageId": "MessageId2",
          "providerResponse": "Network Failure !"
        }
         */
        SMS_MOCKED_RESPONSES.put("MessageId2", "{\"success\":false,\"messageId\":\"MessageId2\",\"providerResponse\":\"NetworkFailure!\"}");


        /*
        {
           "status": "Success"
           "message": "Successfully Sent"
        }
         */
        SMS_DELIVERY_STATUS_MOCKED_RESPONSES.put("MessageId1", "{\"status\":\"Success\"\"message\":\"SuccessfullySent\"}");



        /*
        {
           "status": "Failed"
           "message": "Invalid Message Id"
        }
         */
        SMS_DELIVERY_STATUS_MOCKED_RESPONSES.put("MessageId2", "{\"status\":\"Failed\"\"message\":\"Invalid Message Id\"}");


        /*
        {
          "status": "success",
          "message": "Notification sent successfully",
          "timestamp": "2023-12-01T12:34:56Z",
          "data": {
            "notification_id": "123456789",
            "recipient": "user123",
            "platform": "iOS",
            }
        }
         */
        PN_MOCKED_RESPONSES.put("FCMToken1", "{\"status\":\"success\",\"message\":\"Notificationsentsuccessfully\",\"timestamp\":\"2023-12-01T12:34:56Z\",\"data\":{\"notification_id\":\"123456789\",\"recipient\":\"user123\",\"platform\":\"iOS\",}}");


        /*
        {
          "status": "error",
          "message": "Failed to send notification",
          "timestamp": "2023-12-01T13:45:00Z",
          "error": {
            "code": "500",
            "details": "Internal server error"
          }
        }
         */
        PN_MOCKED_RESPONSES.put("FCMToken2", "{\"status\":\"error\",\"message\":\"Failedtosendnotification\",\"timestamp\":\"2023-12-01T13:45:00Z\",\"error\":{\"code\":\"500\",\"details\":\"Internalservererror\"}}");


        /*
        {
      "status": "success",
      "message": "Email sent successfully",
      "timestamp": "2023-12-01T14:30:00Z",
      "data": {
        "email_id": "test1@gmail.com",
        "recipient": "user@example.com",
        "subject": "Sample Email Subject"
        }
       }
         */
        EMAIL_MOCKED_RESPONSES.put("Email1", "{\"status\":\"success\",\"message\":\"Emailsentsuccessfully\",\"timestamp\":\"2023-12-01T14:30:00Z\",\"data\":{\"email_id\":\"test1@gmail.com\",\"recipient\":\"user@example.com\",\"subject\":\"SampleEmailSubject\"}}");
    }
}
