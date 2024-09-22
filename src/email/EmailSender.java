package email;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    private String smtpHost;
    private String smtpPort;
    private String username;
    private String password;

    public EmailSender(String smtpHost, String smtpPort, String username, String password) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.username = username;
        this.password = password;
    }

    public void sendEmail(String to, String subject, String messageContent) throws MessagingException {
        // Configuración de las propiedades de conexión SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Autenticación y sesión
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Crear el mensaje
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(messageContent);

        // Enviar el mensaje
        Transport.send(message);
        System.out.println("Correo enviado exitosamente!");
    }
}
