package edu.pucmm.josecl200.finalavanzada.notificacionesmicro.servicios;

import com.sendgrid.*;

import java.io.IOException;

public class CorreoServices {
    public void sendEmail(String username, String username_email, String subject, String content){
        Email desdeEmail = new Email("20160138@ce.pucmm.edu.do");
        String asuntoEmail = subject;
        Email paraEmail = new Email(username_email);
        Content cuerpoEmail = new Content("text/plain", content);
        Mail email = new Mail(desdeEmail, asuntoEmail, paraEmail, cuerpoEmail);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(email.build());
            Response response = sg.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
