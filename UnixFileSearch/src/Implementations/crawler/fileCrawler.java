package Implementations.crawler;

import Implementations.EntryImplementations.UnixDirectory;
import Interfaces.Entry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class fileCrawler {

    public ArrayList<String> searchFiles(Entry entry){
        ArrayList<String>  ans = new ArrayList<>();

        Queue<Entry> queue = new LinkedList<>();
        queue.offer(entry);
        String currDir="";
        while(queue.size()>0){
            int qLen = queue.size();

            for(int i=0;i<qLen;i++){
                Entry newEntry = queue.poll();

                if(newEntry.isDirectory()){
                    for(Entry dirEntry:((UnixDirectory)newEntry).getContent()){
                        queue.add(dirEntry);
                    }
                }
                else{
                    ans.add(newEntry.getName());
                }
            }

        }

        return ans;

    }
}
