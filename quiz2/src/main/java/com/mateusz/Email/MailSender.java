package com.mateusz.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


@Service
public class MailSender {

    public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String text,Session session){

        try {
            MimeMessage message =new MimeMessage(session);

           // email z ktorego wysylam wiadomosc
            message.setFrom(new InternetAddress(fromEmail));

            // e-mail tam gdzie bede wysylal
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            //temat wiadomosci
            message.setSubject(subject);

            //tresc wiadomosci
            message.setText(text);

           System.out.println("Tresc wiadomosci tp" + message);

            //wysylanie wiadomosci
            Transport.send(message);

            System.out.println("Wysylanie zakonczone powodzeniem");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
