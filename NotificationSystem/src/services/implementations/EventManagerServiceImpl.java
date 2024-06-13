package services.implementations;

import models.EventManager;
import models.Subscriber;
import models.Bucket;
import services.EventManagerService;
import services.SubscriberService;

import java.util.ArrayList;

public class EventManagerServiceImpl implements EventManagerService {
    EventManager eventManager;
    SubscriberService subscriberService;
    public EventManagerServiceImpl(){
         eventManager= new EventManager();
         subscriberService = new SubscriberServiceImpl();
    }

    @Override
    public void addSubscriber(Bucket topic, Subscriber subscriber) {
        eventManager.addSubscriber(topic,subscriber);

    }

    @Override
    public void notifyAll(Bucket topic, String message) {
        ArrayList<Subscriber> subscribers = eventManager.getBucketSubscribers(topic);
        for(Subscriber subscriber:subscribers){
                subscriberService.notify(subscriber,message);
        }
    }

    @Override
    public void removeSubscriber(Bucket topic, Subscriber subscriber) {
        eventManager.removeSubscriber(topic,subscriber);
    }
}
