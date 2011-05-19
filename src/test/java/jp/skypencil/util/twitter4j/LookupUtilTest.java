package jp.skypencil.util.twitter4j;

import org.junit.Test;

import junit.framework.TestCase;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.api.UserMethods;
import twitter4j.internal.http.HttpResponseCode;


public class LookupUtilTest extends TestCase {
	private static final int UNKNOWN_USER_ID = 9999;
	private static final int VALID_USER_ID = 1;

	private UserMethods twitter = new UserMethodsStub() {
		@Override
		public ResponseList<User> lookupUsers(long[] ids) throws TwitterException {
			ResponseList<User> result = new ResponseListImpl<User>();
			for (int i = 0; i < Math.min(ids.length, 100); ++i) {
				if (ids[i] != UNKNOWN_USER_ID) {
					User user = new UserStub(ids[i]);
					result.add(user);
				}
			}
			if (result.isEmpty()) {
				// Œ©‚Â‚©‚ç‚È‚©‚Á‚½‚ç404
				throw new TwitterException("", null, HttpResponseCode.NOT_FOUND);
			}

			return result;
		}
	};

	@Test
	public void testEmptyId() throws TwitterException {
		long[] emptyId = new long[] {};
		ResponseList<User> result = LookupUtil.lookupUser(twitter, emptyId);
		assertNull(result);
	}

	@Test
	public void testValidId() throws TwitterException {
		long[] emptyId = new long[] {VALID_USER_ID};
		ResponseList<User> result = LookupUtil.lookupUser(twitter, emptyId);
		assertNotNull(result);
		assertTrue(result.size() == 1);
		User user = result.get(0);
		assertNotNull(user);
		assertEquals(new UserStub(VALID_USER_ID).getScreenName(), user.getScreenName());
	}

	@Test
	public void testUnknownId() throws TwitterException {
		long[] emptyId = new long[] {UNKNOWN_USER_ID};
		ResponseList<User> result = LookupUtil.lookupUser(twitter, emptyId);
		assertNull(result);
	}

	@Test
	public void testValidAndUnknownId() throws TwitterException {
		long[] emptyId = new long[] {VALID_USER_ID, UNKNOWN_USER_ID};
		ResponseList<User> result = LookupUtil.lookupUser(twitter, emptyId);
		assertNotNull(result);
		assertTrue(result.size() == 1);
		User user = result.get(0);
		assertNotNull(user);
		assertEquals(new UserStub(VALID_USER_ID).getScreenName(), user.getScreenName());
	}

	@Test
	public void testManyId() throws TwitterException {
		long[] validIds = new long[1000];
		for (int i = 0; i < validIds.length; ++i) {
			assertTrue(i != UNKNOWN_USER_ID);
			validIds[i] = i;
		}

		ResponseList<User> result = LookupUtil.lookupUser(twitter, validIds);
		assertNotNull(result);
		assertTrue(result.size() == validIds.length);
		boolean[] exists = new boolean[validIds.length];
		for (int i = 0; i < validIds.length; ++i) {
			User user = result.get(i);
			assertNotNull(user);
			exists[(int) user.getId()] = true;
		}

		for (boolean exist : exists) {
			assertTrue(exist);
		}
	}
}