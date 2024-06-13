import enums.DeliveryType;
import models.Bucket;
import models.Subscriber;
import services.BucketManagerService;
import services.EventManagerService;
import services.SubscriberService;
import services.implementations.BucketManagerServiceImpl;
import services.implementations.EventManagerServiceImpl;
import services.implementations.SubscriberServiceImpl;

public class main {

    public static void main(String[] args) {
        Subscriber sub1 = new Subscriber(DeliveryType.email,"sss","sathesaurabh30@gmail.com","8989898989");
        Subscriber sub2 = new Subscriber(DeliveryType.email,"sss","sathesaurabh30@gmail.com","8989898989");
        Subscriber sub3 = new Subscriber(DeliveryType.email,"sss","sathesaurabh30@gmail.com","8989898989");
        Subscriber sub4 = new Subscriber(DeliveryType.email,"sss","sathesaurabh30@gmail.com","8989898989");
        Subscriber sub5 = new Subscriber(DeliveryType.email,"sss","sathesaurabh30@gmail.com","8989898989");


        Bucket b1 = new Bucket("aw01");
        Bucket b2 = new Bucket("aw02");

        EventManagerService eventManagerService = new EventManagerServiceImpl();
        eventManagerService.addSubscriber(b1,sub1);
        eventManagerService.addSubscriber(b1,sub2);
        eventManagerService.addSubscriber(b1,sub5);
        eventManagerService.addSubscriber(b1,sub5);
        eventManagerService.addSubscriber(b2,sub3);
        eventManagerService.addSubscriber(b2,sub4);
        eventManagerService.addSubscriber(b2,sub5);


        BucketManagerService bucketManagerService = new BucketManagerServiceImpl((EventManagerServiceImpl) eventManagerService);
        bucketManagerService.addFileToBucket(b1,"newfile1.txt");
        bucketManagerService.addFileToBucket(b1,"newfile2.txt");
        bucketManagerService.addFileToBucket(b2,"newfile3.txt");




    }
}
