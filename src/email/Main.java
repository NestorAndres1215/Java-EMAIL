/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javax.mail.MessagingException;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        // Configuración del servidor SMTP de Gmail
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587";
        String username = "atiroandres@gmail.com";// ESTE CORREO
        String password ="oxqykftzymaycptf";//CODIGO DE TU CORREO

        // Crear una instancia de EmailSender
        EmailSender emailSender = new EmailSender(smtpHost, smtpPort, username, password);
        String asunto = "Actualización del Proyecto";
        String cuerpo = "Hola,\n\n" +
                        "Espero que te encuentres bien. Quiero informarte que hemos avanzado en el proyecto.\n" +
                        "Por favor, revisa los últimos cambios en el repositorio y comunícate si tienes alguna duda.\n\n" +
                        "Saludos,\n" +
                        "El equipo de desarrollo";
        // Enviar un correo de ejemplo
        try {
            emailSender.sendEmail("atiroandres7@gmail.com", asunto,cuerpo);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
