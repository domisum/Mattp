package de.domisum.mattp.auth;

import org.apache.http.impl.client.HttpClientBuilder;

public class NoAuthProvider implements MattpAuthProvider
{

	@Override
	public void provideAuthFor(HttpClientBuilder httpClientBuilder)
	{
		// do nothing
	}

}
