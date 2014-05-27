package twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterClient implements ITwitterClient {

	@Override
	public void publishUuid(TwitterStatusMessage message) throws Exception {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true)
		  .setOAuthConsumerKey("GZ6tiy1XyB9W0P4xEJudQ")
		  .setOAuthConsumerSecret("gaJDlW0vf7en46JwHAOkZsTHvtAiZ3QUd2mD1x26J9w")
		  .setOAuthAccessToken("1366513208-MutXEbBMAVOwrbFmZtj1r4Ih2vcoHGHE2207002")
		  .setOAuthAccessTokenSecret("RMPWOePlus3xtURWRVnv1TgrjTyK7Zk33evp4KKyA");
		Twitter twitter = new TwitterFactory(configurationBuilder.build()).getInstance();
		Status status = twitter.updateStatus(message.getTwitterPublicationString());
	}

}
