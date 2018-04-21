package com.mateusz.Controller;

import com.mateusz.Email.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;

@Controller
public class MailController {

    private static MailSender mailSender;

    @RequestMapping("/email")
    public String mail(){
        return "email";
    }

    @RequestMapping("/mail")
    public String email(HttpServletRequest request) throws ServletException, IOException{

        String toEmail = request.getParameter("email");
        String subject = request.getParameter("subject");
        String text = request.getParameter("message");

        String fromEmail = "javatestmati@gmail.com";
        String userName = "javatestmati";
        String password = "M@tiJavaTest19";

       // System.out.println(fromEmail+ " " + userName+ " " + password+ " " + toEmail + " " + subject+ " " + text);

        String host = "smtp.gmail.com";

        Properties props = System.getProperties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });


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

      //  mailSender.sendEmail(fromEmail, userName, password, toEmail, subject, text);

        return "index";
    }
}
