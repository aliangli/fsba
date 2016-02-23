package com.ulysses.interceptor;

public interface IRedisCacheClient {

	void listLpush(String tokenName0, String token);

	String listLpop(String tokenCacheName);

}
