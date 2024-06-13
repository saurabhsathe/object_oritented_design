package services.implementations;

import models.Bucket;
import models.EventManager;
import services.BucketManagerService;
import services.EventManagerService;

public class BucketManagerServiceImpl  implements BucketManagerService {


    EventManagerService eventManagerService;

    public BucketManagerServiceImpl(EventManagerServiceImpl eventManager){
        eventManagerService = eventManager;

    }

    @Override
    public void addFileToBucket(Bucket topic, String filename){

        topic.addFile(filename);
        this.eventManagerService.notifyAll(topic,"file " +filename +" has been created from topic "+topic.getName());


    }
    @Override
    public void removeFileFromBucket(Bucket topic, String filename){

        topic.removeFile(filename);
        this.eventManagerService.notifyAll(topic,"file " +filename +" has been removed from topic "+topic.getName());


    }
}
