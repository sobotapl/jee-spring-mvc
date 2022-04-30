package pl.coderslab.beans;

public class EmailService implements MessageService {

    @Override
    public void send() {
        System.out.println("Sending email");
    }

    @Override
    public void send(String message) {
        System.out.println(message);
    }
}