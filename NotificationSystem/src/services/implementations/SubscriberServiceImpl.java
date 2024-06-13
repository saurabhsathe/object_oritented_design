package services.implementations;

import enums.DeliveryType;
import models.Subscriber;
import services.SubscriberService;

public class SubscriberServiceImpl implements SubscriberService {
   EmailServiceImpl emailService;
    public SubscriberServiceImpl(){
        emailService = new EmailServiceImpl();

    }
    @Override
    public void notify(Subscriber subscriber, String message) {
        if(subscriber.getDeliveryType()== DeliveryType.email){
            if(!subscriber.getEmail().isEmpty())
                emailService.sendEmail(subscriber.getEmail(), message);
        }else{
            if(!subscriber.getPhoneNumber().isEmpty())
                emailService.sendEmail(subscriber.getEmail(), message);
        }
    }
}
