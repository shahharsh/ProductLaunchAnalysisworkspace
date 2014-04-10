package com.jdwb.twitterapi;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class configurationbuilder {
	public ConfigurationBuilder connect()
	{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("etJGQZ7VNIdIQQVibPQg");
        cb.setOAuthConsumerSecret("iFVJ63lo7JrXdTlH8Kpb3l02WmdhpEHCeFNiA9UXYxI");
        
		//twitter.setOA
        cb.setOAuthAccessToken("153641276-1TzewMZ7e5y6Oa9WuMck8F4gLRNPhLzQ6HQAzxIG");
		cb.setOAuthAccessTokenSecret("6gO7k01FZ6VI5uwQFfSSgYqwF1kEUWPnEIIHD0YnHMJsL");
		return cb;
	}

}
