/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriatwitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Zarza
 */
public class Metodos {
    
    Twitter twitter;

    /**
     * Método para acceder a la cuenta con los datos que nos da Twitter Apps
     */
    public Metodos() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true)
         .setOAuthConsumerKey("5zO44Aeo4gLC52fvhqaocpU9P")
         .setOAuthConsumerSecret("0u0YwQrnI5OG4ZpactT4Vyl9eNJbVBdKPhbLOghrCH6sHefcwh")
         .setOAuthAccessToken("182041479-hoD2StntYm3bdCDQFMjueknzKf5YhGIS9OnZNS37")
         .setOAuthAccessTokenSecret("hocHHSwrb0WFbl6g4JI6UdqY9VEUZT3mRqG0ANCU7Jzao");
         twitter = new TwitterFactory(cb.build()).getInstance();
        twitter = new TwitterFactory("twitter4j.properties").getInstance();
    }
    /**
     * Muestra el timeline
     * @throws twitter4j.TwitterException
     */
    public void verTimeLine() throws TwitterException {

        ResponseList<twitter4j.Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (twitter4j.Status status : statuses) {
            System.out.println(status.getUser().getName() + ":"
                    + status.getText());
        }

    }

    /**
     * Buscador de Tweets
     * @param buscar
     * @throws twitter4j.TwitterException
     */
    public void buscarTweet(String buscar) throws TwitterException {

        Query query = new Query(buscar);
        QueryResult result = twitter.search(query);
        for (twitter4j.Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }

    }

    /**
     * Crea y publica un tweet
     * @param tweet
     * @throws twitter4j.TwitterException
     */
    public void escribirTweet(String tweet) throws TwitterException {

        twitter4j.Status status = twitter.updateStatus(tweet);
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }
}
