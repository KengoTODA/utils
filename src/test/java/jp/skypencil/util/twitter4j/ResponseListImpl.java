package jp.skypencil.util.twitter4j;

import java.util.ArrayList;

import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;

public class ResponseListImpl<T> extends ArrayList<T> implements ResponseList<T> {
	private static final long serialVersionUID = -7756493664643750242L;

	@Override
	public RateLimitStatus getFeatureSpecificRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}
}
