package services;

import models.Subscriber;
import models.Bucket;

public interface EventManagerService {


    void addSubscriber(Bucket topic, Subscriber subscriber);
    void removeSubscriber(Bucket topic, Subscriber subscriber);
    void notifyAll(Bucket topic, String message);


}
