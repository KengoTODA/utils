package jp.skypencil.util.twitter4j;

import java.net.URL;
import java.util.Date;

import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.User;

public class UserStub implements User {
	private static final long serialVersionUID = -9188563098306361931L;
	private String screenName;
	private long id;

	public UserStub(long id) {
		this.id = id;
		this.screenName = Long.toString(id);
	}

	@Override
	public Date getCreatedAt() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public int getFavouritesCount() {
		return 0;
	}

	@Override
	public int getFollowersCount() {
		return 0;
	}

	@Override
	public int getFriendsCount() {
		return 0;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getLang() {
		return null;
	}

	@Override
	public int getListedCount() {
		return 0;
	}

	@Override
	public String getLocation() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getProfileBackgroundColor() {
		return null;
	}

	@Override
	public String getProfileBackgroundImageUrl() {
		return null;
	}

	@Override
	public URL getProfileImageURL() {
		return null;
	}

	@Override
	public String getProfileLinkColor() {
		return null;
	}

	@Override
	public String getProfileSidebarBorderColor() {
		return null;
	}

	@Override
	public String getProfileSidebarFillColor() {
		return null;
	}

	@Override
	public String getProfileTextColor() {
		return null;
	}

	@Override
	public String getScreenName() {
		return screenName;
	}

	@Override
	public Status getStatus() {
		return null;
	}

	@Override
	public int getStatusesCount() {
		return 0;
	}

	@Override
	public String getTimeZone() {
		return null;
	}

	@Override
	public URL getURL() {
		return null;
	}

	@Override
	public int getUtcOffset() {
		return 0;
	}

	@Override
	public boolean isContributorsEnabled() {
		return false;
	}

	@Override
	public boolean isFollowRequestSent() {
		return false;
	}

	@Override
	public boolean isGeoEnabled() {
		return false;
	}

	@Override
	public boolean isProfileBackgroundTiled() {
		return false;
	}

	@Override
	public boolean isProtected() {
		return false;
	}

	@Override
	public boolean isVerified() {
		return false;
	}

	@Override
	public int compareTo(User o) {
		return 0;
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		return null;
	}

	@Override
	public boolean isProfileUseBackgroundImage() {
		return false;
	}

	@Override
	public boolean isShowAllInlineMedia() {
		return false;
	}

	@Override
	public boolean isTranslator() {
		return false;
	}
}
