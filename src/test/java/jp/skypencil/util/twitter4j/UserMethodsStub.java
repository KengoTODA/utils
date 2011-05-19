package jp.skypencil.util.twitter4j;

import twitter4j.Category;
import twitter4j.PagableResponseList;
import twitter4j.ProfileImage;
import twitter4j.ProfileImage.ImageSize;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.UserMethods;

public class UserMethodsStub implements UserMethods {
	@Override
	public PagableResponseList<User> getFollowersStatuses(long cursor) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public PagableResponseList<User> getFollowersStatuses(String screenName, long cursor) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public PagableResponseList<User> getFriendsStatuses(long cursor) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public PagableResponseList<User> getFriendsStatuses(String screenName, long cursor) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public ResponseList<Category> getSuggestedUserCategories() throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public ResponseList<User> getUserSuggestions(String categorySlug) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public ResponseList<User> lookupUsers(String[] screenNames) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public ResponseList<User> searchUsers(String query, int page) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public User showUser(String screenName) throws TwitterException {
		throw new UnsupportedOperationException();
	}
	@Override
	public User showUser(long userId) throws TwitterException {
		return null;
	}
	@Override
	public ResponseList<User> lookupUsers(long[] ids) throws TwitterException {
		return null;
	}
	@Override
	public ResponseList<User> getMemberSuggestions(String categorySlug)
			throws TwitterException {
		return null;
	}
	@Override
	public ProfileImage getProfileImage(String screenName, ImageSize size)
			throws TwitterException {
		return null;
	}
	@Override
	public PagableResponseList<User> getFriendsStatuses(long userId, long cursor)
			throws TwitterException {
		return null;
	}
	@Override
	public PagableResponseList<User> getFollowersStatuses(long userId,
			long cursor) throws TwitterException {
		return null;
	}
}
