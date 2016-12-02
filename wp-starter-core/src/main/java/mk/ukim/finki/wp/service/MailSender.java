package mk.ukim.finki.wp.service;

/**
 * Created by ristes on 11/25/16.
 */
public interface MailSender {

  public void sendMail(String to, String subject, String body);
}
