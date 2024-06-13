package services;

import models.Bucket;

public interface BucketManagerService {

    public void addFileToBucket(Bucket topic, String filename);
    public void removeFileFromBucket(Bucket topic, String filename);

}
