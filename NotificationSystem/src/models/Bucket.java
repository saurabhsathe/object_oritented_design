package models;

import java.util.ArrayList;

public class Bucket {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    ArrayList<String> filenames;
    public Bucket(String bucketName){
        name=bucketName;
        filenames=new ArrayList<>();



    }
    public void addFile(String file){
        filenames.add(file);

    }
    public void removeFile(String file){
        filenames.remove(file);

    }

}
