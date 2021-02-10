package edu.rosehulman.covidtracer.service;

import com.sendgrid.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    public void sendEmail(String from, String subject, String to, String templateId) throws IOException{
        Email fromAddress = new Email(from);
        Email toAddress = new Email(to);
        Content content = new Content("text/html", "Covid Tracer Stuff");
        Mail mail = new Mail(fromAddress, subject, toAddress, content);
        mail.setTemplateId(templateId);

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
            System.out.println("Email sent: From: " + from + ", To: " + to + ", Reason: " + subject);
        }
        catch (IOException ex) {
            throw ex;
        }
    }

    public void sendTestEmail() throws IOException {
    Email from = new Email("rhitcovidtracer@gmail.com");
    String subject = "Sending with SendGrid is Fun";
    Email to = new Email("maura.coriale@gmail.com");
    Content content = new Content("text/html", "test");
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

    public void alertAllOfNewCase(String caseId) {
        //need to send emails to everyone who has a role
        //can start by grabbing all w/ role from database
    }

    public void alertTracerOfNewCase(String caseId) {
        //need to send email to the person assigned to a particular case
        //grab the recipient (tracer) from the database
    }

    public void alertPositivePoolMembers(String poolId) {
        //need to send an email to the people who are part of a positive pool
    }

    public void alertAllOfNewPositivePool(String poolId) {
        //calls alertPositivePoolMembers
        //sends email to the authority figures like the contact tracers,
        //student affairs, etc.
        //also sends the email to the students (alertPositivePoolMembers)
    }
}
