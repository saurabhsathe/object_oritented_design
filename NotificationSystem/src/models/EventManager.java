package models;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager {


    HashMap<Bucket, ArrayList<Subscriber>> bucketSubscribers;

    public EventManager() {
        this.bucketSubscribers =  new HashMap<>();
    }

    public void addSubscriber(Bucket bucket, Subscriber subscriber){


            ArrayList<Subscriber> subs = bucketSubscribers.getOrDefault(bucket, new ArrayList<>());
            if(subs.contains(subscriber)){
                System.out.println("Subscriber "+subscriber.getName() +" already subscribed");
                return;
            }
            subs.add(subscriber);
            bucketSubscribers.put(bucket,subs);
            System.out.println("Subscriber "+subscriber.getName() +" added successfully");


    }

    public void removeSubscriber(Bucket bucket, Subscriber subscriber){


        ArrayList<Subscriber> subs = bucketSubscribers.getOrDefault(bucket, new ArrayList<>());
        if(!subs.contains(subscriber)){
            System.out.println("Subscriber not subscribed");
            return;
        }
        subs.remove(subscriber);
        bucketSubscribers.put(bucket,subs);


    }


    public ArrayList<Subscriber> getBucketSubscribers(Bucket bucket){

        for(Bucket bucket1: bucketSubscribers.keySet()){
            System.out.println(bucket.toString()+" bucket found");
        }
        if(!bucketSubscribers.containsKey(bucket)){
            System.out.println("Bucket not found in the EventManager");
            return null;
        }
        return bucketSubscribers.get(bucket);

    }
}
