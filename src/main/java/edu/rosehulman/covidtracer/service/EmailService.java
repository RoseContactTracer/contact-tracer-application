package edu.rosehulman.covidtracer.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import edu.rosehulman.covidtracer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    PersonService personService;

    @Value("${sendgrid.api-key}")
    String apiKey;

    @Value("${email.template.basic}")
    String basicTemplate;

    public void sendEmail(String from, String subject, String to, String templateId) throws IOException{
        Email fromAddress = new Email(from);
        Email toAddress = new Email(to);
        Content content = new Content("text/html", "Covid Tracer Stuff");
        Mail mail = new Mail(fromAddress, subject, toAddress, content);
        mail.setTemplateId(templateId);
        Personalization p = new Personalization();
        String toName = personService.getNameFromEmail(to);
        System.out.println(toName);
        p.addDynamicTemplateData("first_name", "Maura Coriale");
        //p.addSubstitution("firstName", toName);
        //p.addSubstitution("firstName", toName);
        p.addTo(toAddress);
        mail.personalization.add(p);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            System.out.println(request.getBody());
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
        String from = "rhitcovidtracer@gmail.com";
        String subject = "Sending with SendGrid is Fun";
        String to = "maura.coriale@gmail.com";
        sendEmail(from, subject, to, basicTemplate);
    }

    public void alertAllOfNewCase(String caseId) {
        //need to send emails to everyone who has particular role (Head Contact Tracer, Student Affairs)
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
