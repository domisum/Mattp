package de.domisum.mattp.response;

import de.domisum.lib.auxilium.util.java.annotations.API;
import de.domisum.mattp.header.MattpHeaders;

import java.io.IOException;
import java.util.Optional;

public interface RequestResponse<T>
{

	@API
	boolean isSuccess();


	@API
	Optional<StatusLine> getStatusLine();

	@API
	Optional<MattpHeaders> getHeaders();

	@API
	Optional<T> getContent();


	@API
	Optional<String> getErrorMessage();

	@API
	default void throwExceptionIfFailed(String message) throws IOException
	{
		if(isSuccess())
			return;

		throw new IOException(message+"; error: "+getErrorMessage().orElse("<no error message>"));
	}

}
