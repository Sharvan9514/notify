package com.NotifEaze.NotifEaze.mock;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KayleraMock {
    private static final Map<String, String> SMS_MOCKED_RESPONSES = new HashMap<>();
    private static final Map<String, String> EMAIL_MOCKED_RESPONSES = new HashMap<>();

    public String getSmsResponse(String number)
    {
        return SMS_MOCKED_RESPONSES.get(number);
    }


    static {


        /*
        <?xml version="1.0" encoding="UTF-8" ?>
            <root>
                <status>00</status>
                <messageId>123456</messageId>
                <responseMessage>Success</responseMessage>
            </root>
        */
        SMS_MOCKED_RESPONSES.put("123456", "&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; ?&gt;\n" +
                "&lt;root&gt;\n" +
                "\t&lt;status&gt;0&lt;/status&gt;\n" +
                "\t&lt;messageId&gt;123456&lt;/messageId&gt;\n" +
                "\t&lt;responseMessage&gt;Success&lt;/responseMessage&gt;\n" +
                "&lt;/root&gt;");

        /*
        <?xml version="1.0" encoding="UTF-8" ?>
            <root>
                <status>1</status>
                <messageId>789012</messageId>
                <responseMessage>Failed</responseMessage>
            </root>
         */
        SMS_MOCKED_RESPONSES.put("789012", "&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; ?&gt;\n" +
                "&lt;root&gt;\n" +
                "\t&lt;status&gt;1&lt;/status&gt;\n" +
                "\t&lt;messageId&gt;789012&lt;/messageId&gt;\n" +
                "\t&lt;responseMessage&gt;Failed&lt;/responseMessage&gt;\n" +
                "&lt;/root&gt;");
    }
}
