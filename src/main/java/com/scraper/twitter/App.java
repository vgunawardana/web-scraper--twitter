package com.scraper.twitter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class App 
{
    public static void main( String[] args )
    {
    	try {
    		
    		Document doc = Jsoup.connect("https://twitter.com/realDonaldTrump").get();
    		
    		System.out.printf("Title : %s\n",doc.title());
    		
    		//Get access to each tweet
    		Elements repositories = doc.getElementsByClass("stream-item");
    		int count = 0;
    		
    		for(Element repository : repositories) {
    			String tweetText = repository.getElementsByClass("tweet-text").text();
    			
    			System.out.println(tweetText);
    			count++;
    		}
    		
    		System.out.println(count);
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
       
    }
}
