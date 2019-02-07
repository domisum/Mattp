package de.domisum.mattp.auth;

import org.apache.http.impl.client.HttpClientBuilder;

public interface MattpAuthProvider
{

	void provideAuthFor(HttpClientBuilder httpClientBuilder);

}
