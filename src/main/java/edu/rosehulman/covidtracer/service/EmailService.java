package edu.rosehulman.covidtracer.service;

import com.sendgrid.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

// using SendGrid's Java Library
// https://github.com/sendgrid/sendgrid-java

    public void sendTestEmail(){
    Email from = new Email("test@example.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("test@example.com");
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();

    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
        try {
            request.setBody(mail.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Response response = null;
        try {
            response = sg.api(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.getStatusCode());
    System.out.println(response.getBody());
    System.out.println(response.getHeaders());

    }
}
