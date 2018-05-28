 package javaapplication3;

import javax.swing.*;
import java.awt.event.*;

import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class gui_twitter extends JFrame
 {
	gui_twitter()
	{
	 setTitle("Tugas Akses twitter" );
	 setLocation(300,100 );
	 setSize(900,420 );
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}
	JTextArea hasil=new JTextArea();
	
	void KomponenVisual()
	{
	 getContentPane().add(hasil );
	 hasil.setBounds(10,230,270,140 );
	 setVisible(true );
	}
	
    private final static String CONSUMER_KEY = "cV0X19HXfdgdfgdg34DFSwRS6nqb";
    private final static String CONSUMER_KEY_SECRET = "mY09iMC3rfDZnaHYydfgsddsfIG7oaoUtqdfgeresdfsbtwH6TsuKrh";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	//twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	hasil.append("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    hasil.append("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n"+ "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "vIYcjr8wY1jghfjkfkyuOqbi5tgGbE18ESsefsfsg3la4DFM53T";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "83576715-EPVefsfsn5JtGeNX8H0nPRxsdfsxgcyJdvs7bwHJ";
    }

    public static void main(String[] args) throws Exception
    	 {
		gui_twitter e5=new gui_twitter();
		e5.start();
		e5.KomponenVisual();
    }
}
