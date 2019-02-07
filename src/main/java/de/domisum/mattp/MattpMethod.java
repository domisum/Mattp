package de.domisum.mattp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MattpMethod
{

	GET(false),
	HEAD(false),
	OPTIONS(false),
	TRACE(false),

	POST(true),
	PUT(true),
	DELETE(true),
	PATCH(true);

	@Getter
	private final boolean hasRequestBody;

}
