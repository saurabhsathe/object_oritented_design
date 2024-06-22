import java.util.ArrayList;
import java.util.HashMap;

class Bucket{

    String name;
    ArrayList<String> files;

    public Bucket(String name){
        this.name  = name;
        files= new ArrayList<>();
    }
    public void addFiles(String fileName){
        files.add(fileName);

    }
    public void removeFiles(String fileName){
        if (files.contains(fileName)){
            files.remove(fileName);
        }
    }
}
class Subscriber{

    String name;
    String email;

    public Subscriber(String name, String email){
        this.name  = name;
        this.email  = email;
    }
    public String getEmail(){
        return email;

    }

}
class BucketSubscribers{

    HashMap<Bucket,ArrayList<Subscriber>> bucketSubscribers;

    public BucketSubscribers(){
        bucketSubscribers = new HashMap<>();

    }
    public void addBucket(Bucket bucket){
        bucketSubscribers.put(bucket,new ArrayList<>());
    }
    public void addSubscriber(Bucket bucket, Subscriber subscriber){
        if(!bucketSubscribers.containsKey(bucket)){
            System.out.println("Bucket not in system please add first");
            return;
        }
        ArrayList<Subscriber> temp = bucketSubscribers.get(bucket);
        temp.add(subscriber);
        bucketSubscribers.put(bucket,temp);
    }

    public void removeSubscriber(Bucket bucket, Subscriber subscriber){
        if(!bucketSubscribers.containsKey(bucket)){
            System.out.println("Bucket not in system please add first");
            return;
        }
        ArrayList<Subscriber> temp = bucketSubscribers.get(bucket);
        if(!temp.contains(subscriber)){
            System.out.println("Subscriber niot subscribed");
            return;
        }
        temp.remove(subscriber);
        bucketSubscribers.put(bucket,temp);
    }
    public ArrayList<Subscriber> getBucketSubscribers(Bucket bucket){

     return bucketSubscribers.getOrDefault(bucket, new ArrayList<>());
    }

}


interface BucketSubscriberManagerService{
    public void addSubscriber(Bucket bucket, Subscriber sub);
    public void removeSubscriber(Bucket bucket, Subscriber sub);
    public void notifySubscribers(Bucket bucket , String data);
    public void addBucket(Bucket bucket);

}

interface BucketManagerService{

    public void addFileToBucket(Bucket bucket, String file);
    public void removeFileFromBucket(Bucket bucket, String file);

}
interface NotificationService{

    public void notify(Subscriber sub, String data);

}


 class BucketSubscriberManagerServiceImpl implements  BucketSubscriberManagerService{

     BucketSubscribers bucketSubscriber;
     NotificationService notificationService;

     public void addBucket(Bucket b){
         bucketSubscriber.addBucket(b);

     }
    public  BucketSubscriberManagerServiceImpl(NotificationService notificationService){

        bucketSubscriber = new BucketSubscribers();
        this.notificationService = notificationService;

    }

    public void addSubscriber(Bucket bucket, Subscriber sub){

        bucketSubscriber.addSubscriber(bucket,sub);

    }
    public void removeSubscriber(Bucket bucket, Subscriber sub){

        bucketSubscriber.removeSubscriber(bucket,sub);
    }

    public void notifySubscribers(Bucket bucket , String data){
        for(Subscriber  sub : bucketSubscriber.getBucketSubscribers(bucket)){
            notificationService.notify(sub,data);
        }

    }

}
class BucketManagerServiceImpl implements  BucketManagerService{
    BucketSubscriberManagerService bucketSubscriberManagerService;
    public BucketManagerServiceImpl(BucketSubscriberManagerService bucketSubscriberManagerService){

        this.bucketSubscriberManagerService = bucketSubscriberManagerService;

    }

    public void addFileToBucket(Bucket bucket, String file){

        bucket.addFiles(file);
        bucketSubscriberManagerService.notifySubscribers(bucket, "File has been added with name"+file);

    }
    public void removeFileFromBucket(Bucket bucket, String file){

        bucket.removeFiles(file);
        bucketSubscriberManagerService.notifySubscribers(bucket, "File has been removed with name"+file);

    }
}

class EmailNotificationServiceImpl implements  NotificationService{

    public void notify(Subscriber sub, String data){

        System.out.println("Email having data"+data+"has been sent to "+sub.getEmail());
    }

}


public class OneFile {


    public static void main(String[] args) {
            Subscriber sub1=  new Subscriber("sss1","sss1@gmail.com");
            Subscriber sub2=  new Subscriber("sss2","sss2@gmail.com");
            Subscriber sub3=  new Subscriber("sss3","sss3@gmail.com");


            Bucket b1  = new Bucket("bucekt1");
            Bucket b2  = new Bucket("bucket2");

            NotificationService notificationService = new EmailNotificationServiceImpl();
            BucketSubscriberManagerService bucketSubscriberManagerService = new BucketSubscriberManagerServiceImpl(notificationService);
            BucketManagerService bucketManagerService = new BucketManagerServiceImpl(bucketSubscriberManagerService);

            bucketSubscriberManagerService.addBucket(b1);
        bucketSubscriberManagerService.addBucket(b2);


            bucketSubscriberManagerService.addSubscriber(b1,sub1);
        bucketSubscriberManagerService.addSubscriber(b1,sub2);
        bucketSubscriberManagerService.addSubscriber(b2,sub3);


            bucketManagerService.addFileToBucket(b1,"File 1");
            bucketManagerService.addFileToBucket(b1,"File 2");
            bucketManagerService.addFileToBucket(b2,"File 3");

        bucketManagerService.removeFileFromBucket(b1,"File 1");





    }
}
