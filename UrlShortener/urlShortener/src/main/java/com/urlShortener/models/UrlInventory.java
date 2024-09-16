package com.urlShortener.models;

import java.util.HashMap;

public class UrlInventory {

    private static HashMap<String,String> urlStore = new HashMap<>();


    public boolean addShortUrl (String shortUrl,String originalUrl){

        try{
                if(urlStore.containsKey(shortUrl)){
                    throw  new Exception("short url already taken");
                }

                urlStore.put(shortUrl,originalUrl);
                System.out.println("Inserted successfully");
                return true;
        }
        catch(Exception e){
            System.out.println("Encountered an exception while adding the shortened url"+e);
            return false;
        }

    }

    public String getOriginalUrl(String shortUrl){
        String result ="";
        try{
            if(!urlStore.containsKey(shortUrl)){
                throw new Exception("Short url not present");
            }
            result = urlStore.get(shortUrl);
        }
        catch (Exception e){

            System.out.println("Encountered an exception while adding the shortened url"+e);

        }
        finally {
            return result;
        }
    }



}
