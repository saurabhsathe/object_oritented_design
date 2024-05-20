package Implementations.EntryImplementations;

import Interfaces.Entry;

public class UnixFile implements Entry {


    String fileName;
    String content;

    public UnixFile(String fileName) {
        this.fileName = fileName;
    }


    public UnixFile(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void setName(String name) {
        this.fileName=name;
    }

    @Override
    public String getName() {
        return this.fileName;
    }

    @Override
    public Integer getSize() {
        if(!content.isEmpty()) {
            return this.content.length();
        }
        else{
            return 0;
        }
    }

    @Override
    public Boolean isDirectory() {
        return Boolean.FALSE;
    }

    public void setContent(String content){

        this.content=content;


    }

    public String getExtension(){

        return fileName.split(".")[1];
    }

}
