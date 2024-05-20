package Implementations.EntryImplementations;

import Interfaces.Entry;

import java.util.ArrayList;

public class UnixDirectory implements Entry {

    String dirName;
    ArrayList<Entry> content = new ArrayList<>();


    public UnixDirectory(String dirName, ArrayList<Entry> content) {
        this.dirName = dirName;
        this.content = content;
    }

    @Override
    public void setName(String name) {
        this.dirName = dirName;
    }

    @Override
    public String getName() {
        return this.dirName;
    }

    @Override
    public Integer getSize() {
        return content.size();
    }

    @Override
    public Boolean isDirectory() {
        return Boolean.TRUE;
    }

    public void addFiles(Entry entry){
        content.add(entry);

    }
    public ArrayList<Entry> getContent(){
        return content;

    }


}
