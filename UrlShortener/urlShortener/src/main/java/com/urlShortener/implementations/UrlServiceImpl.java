package com.urlShortener.implementations;


import com.urlShortener.models.UrlInventory;
import com.urlShortener.services.UrlService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UrlServiceImpl  implements UrlService {

    private static final String BASE_DOMAIN = "http://yourdomain.com/";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+-";
    private static final int BASE = ALPHABET.length();
    private static int minid = (int) Math.pow(BASE, 5);
    private static int maxid = (int) Math.pow(BASE, 6)+1;
    private SecureRandom random = new SecureRandom();

    private UrlInventory urlInventory = new UrlInventory();
    private  String generateHash(){

        StringBuilder sb = new StringBuilder();
        int num = random.nextInt(maxid-minid+1);

        while(num>0){
            sb.append(ALPHABET.charAt(num%BASE));
            num= num/BASE;
        }

        return sb.reverse().toString();

    }
    public String generateShortUrl(String orignalUrl){
       String shortUrl =  generateHash();
       urlInventory.addShortUrl(shortUrl,orignalUrl);
       return shortUrl;

    }
    public String getOriginalUrl(String shortUrl){

        return urlInventory.getOriginalUrl(shortUrl);

    }


}
