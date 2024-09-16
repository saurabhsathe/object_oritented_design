package com.urlShortener.services;


public interface UrlService {



    String generateShortUrl(String orignalUrl);
    String getOriginalUrl(String shortUrl);



}
