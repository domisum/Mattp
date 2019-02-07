package de.domisum.mattp.request;

import de.domisum.lib.auxilium.util.java.annotations.API;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MattpMethod
{

	@API GET(false),
	@API HEAD(false),
	@API OPTIONS(false),
	@API TRACE(false),

	@API POST(true),
	@API PUT(true),
	@API DELETE(true),
	@API PATCH(true);


	private final boolean allowsRequestBody;


	// GETTERS
	public boolean allowsRequestBody()
	{
		return allowsRequestBody;
	}

}
