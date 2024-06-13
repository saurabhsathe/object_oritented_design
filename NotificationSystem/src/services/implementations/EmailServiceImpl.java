package services.implementations;

import services.EmailService;

public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String email, String data) {
        System.out.println("Sending "+data+" to "+ email);
    }
}
