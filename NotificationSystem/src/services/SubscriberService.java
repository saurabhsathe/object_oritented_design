package services;

import models.Subscriber;

public interface SubscriberService {


    void notify(Subscriber subscriber,String message);
}
