package com.urlShortener.controllers;


import com.urlShortener.ViewObjects.UrlVo;
import com.urlShortener.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/url")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping("/getShortUrl")
    public ResponseEntity<String> getShortUrl(@RequestBody UrlVo data){
        String orignalUrl  = data.getOriginalUrl();
        return new ResponseEntity<>(urlService.generateShortUrl(orignalUrl), HttpStatusCode.valueOf(200));

    }
    @GetMapping("/getOriginalUrl")
    public ResponseEntity<String> getOriginalUrl(@RequestParam String shortUrl){

        return new ResponseEntity<>(urlService.getOriginalUrl(shortUrl), HttpStatusCode.valueOf(200));

    }


}
