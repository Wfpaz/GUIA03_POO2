/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author walte
 */
@WebServlet(name = "EnviarCorreoServ", urlPatterns = {"/EnviarCorreoServ"})
public class EnviarCorreoServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        String resourceName = "cofig.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties cofig = new Properties();
        try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            cofig.load(resourceStream);
        }

        final String gmailAccount = cofig.getProperty("gmail.account");
        final String gmailPassword = cofig.getProperty("gmail.password");
        final String[] emailDestinations = request.getParameterValues("email");

        Session session;
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(gmailAccount,gmailPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(gmailAccount));

            for (String emailDestination : emailDestinations) {
                message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestination));
            }

            message.setSubject("Email Subject - Asunto del correo electronico");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Email text Body - Texto o cuerpo del correo electronico");

            Multipart multipart = new MimeMultipart();
//            for (String attachmentFile : attachmentFiles) {
//                addAttachment(multipart, attachmentFile);
//            }

            //Setting email text message
            multipart.addBodyPart(messageBodyPart);

            //set the attachments to the email
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Correo enviado");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
