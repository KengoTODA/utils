package jp.skypencil.util.twitter4j;

import java.util.Iterator;

import twitter4j.IDs;
import twitter4j.TwitterException;
import twitter4j.api.FriendsFollowersMethods;

public final class FollowersIterator implements Iterable<Long> {
	private final FriendsFollowersMethods twitter;

	public FollowersIterator(FriendsFollowersMethods twitter) {
		this.twitter = twitter;
	}

	@Override
	public Iterator<Long> iterator() {
		return new Iter(twitter);
	}

	private static class Iter implements Iterator<Long> {
		private final FriendsFollowersMethods twitter;
		private long cursor;
		
		private int nextIndex = -1;
		private long[] idList;

		Iter(FriendsFollowersMethods twitter) {
			this.cursor = -1L;
			this.twitter = twitter;
		}

		@Override
		public boolean hasNext() {
			try {
				if (idList == null || idList.length <= nextIndex) {
					IDs ids = twitter.getFollowersIDs(cursor);
					idList = ids.getIDs();
					nextIndex = 0;
					cursor = ids.getNextCursor();
				}
		
				return idList.length > 0;
			} catch (TwitterException e) {
				// TODO �K�؂ȗ�O�ɖ|��
				throw new RuntimeException(e);
			}
		}
	
		@Override
		public Long next() {
			Long next = idList[nextIndex];
			++nextIndex;
			return next;
		}
	
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}