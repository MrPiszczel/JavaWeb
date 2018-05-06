package com.mateusz.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;


public class MailSender {


    public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String text){


            String host = "smtp.gmail.com";

            Properties props = System.getProperties();

            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465"); //465
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");


            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });


            try {
                MimeMessage message =new MimeMessage(session);

                //email z ktorego wysylam wiadomosc
                message.setFrom(new InternetAddress(fromEmail));

                //e-mail tam gdzie bede wysylal
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

            //session.setDebug(true);

            //Message mailMessage = new MimeMessage(session);

            // mailMessage.setFrom(new InternetAddress(fromEmail));
            // mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //mailMessage.setText(message);
            //mailMessage.setSubject(subject);

            //Transport transport = session.getTransport("smtp");
            //transport.connect("smtp.gmail.com",username,password);
            //transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

            //}catch (Exception ex) {
            //Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
            //}

    }
}
