package jp.skypencil.util.twitter4j;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.api.UserMethods;

public final class LookupUtil {
	private static final int LOOKUP_USER_LIMIT = 100;

	private LookupUtil() {}

	/**
	 * 
	 * @param methods Twitter�N���X�̃C���X�^���X
	 * @param id ���ׂ郆�[�UID�̔z��
	 * @return ���X�|���X�̌��ʁinull�����j
	 * @throws TwitterException
	 */
	// TODO Iterator�ŕԂ��ׂ��Ȃ񂶂�Ȃ���
	public static ResponseList<User> lookupUser(UserMethods methods, long id[]) throws TwitterException {
		ResponseList<User> result = null;

		// lookupUsers��100���܂ł����g���Ȃ��̂�100��������Ă���
		for (int startIdx = 0; startIdx < id.length; startIdx += LOOKUP_USER_LIMIT) {
			int endIdx = Math.min(startIdx + LOOKUP_USER_LIMIT - 1, id.length - 1);
			long[] users = new long[endIdx - startIdx + 1];
			System.arraycopy(id, startIdx, users, 0, users.length);

			try {
				ResponseList<User> lookuped = methods.lookupUsers(users);
				if (result != null) {
					lookuped.addAll(result);
				}
				result = lookuped;
			} catch (TwitterException e) {
				if (e.resourceNotFound()) {
					continue;
				} else {
					throw e;
				}
			}
		}

		return result;
	}

	public static final long ILLEGAL_LIST_ID = -1;
	public static long lookupListId(final Twitter twitter,
			final String ownerScreenName, final String listName)
			throws TwitterException {
		long listId = ILLEGAL_LIST_ID;
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
