package jp.skypencil.util.twitter4j;

import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserList;
import twitter4j.auth.AccessToken;

public final class TwitterUtils {
	public static final int ILLEGAL_LIST_ID = -1;

	private TwitterUtils() {}
	
	public static Twitter login(String token, String tokenSecret) {
		final AccessToken accessToken = new AccessToken(token, tokenSecret);
		final TwitterFactory fact = new TwitterFactory();
		return fact.getInstance(accessToken);
	}

	public static int getListId(final Twitter twitter,
			final String ownerScreenName, final String listName)
			throws TwitterException {
		int listId = ILLEGAL_LIST_ID;
		final PagableResponseList<UserList> lists = twitter.getUserLists(
				ownerScreenName, -1);

		for (UserList userList : lists) {
			if (userList.getName().equals(listName)) {
				listId = userList.getId();
				break;
			}
		}
		if (listId == ILLEGAL_LIST_ID) {
			throw new RuntimeException();
		}

		return listId;
	}
}