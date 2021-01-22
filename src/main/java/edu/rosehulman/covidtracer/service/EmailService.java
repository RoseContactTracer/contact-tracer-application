package edu.rosehulman.covidtracer.service;

import com.sendgrid.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    public void sendTestEmail() throws IOException {
    Email from = new Email("rhitcovidtracer@gmail.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("corialmt@rose-hulman.edu");
    Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
    Mail mail = new Mail(from, subject, to, content);
        mail.setTemplateId("d-8df5b581b0374da4a401390264d80200");

    SendGrid sg = new SendGrid("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");
    Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            System.out.println("We did it y'all");
        }
        catch (IOException ex) {
            throw ex;
        }
    }
}
