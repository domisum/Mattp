package de.domisum.mattp.response.responses;

import de.domisum.lib.auxilium.util.PHR;
import de.domisum.mattp.header.MattpHeaders;
import de.domisum.mattp.response.RequestResponse;
import de.domisum.mattp.response.StatusLine;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RequestSuccess<T> implements RequestResponse<T>
{

	private final StatusLine statusLine;
	private final MattpHeaders headers;
	private final T body;


	// OBJECT
	@Override
	public String toString()
	{
		return PHR.r("SUCCESS | {}: {}", statusLine, body);
	}


	// GETTERS
	@Override
	public boolean isSuccess()
	{
		return true;
	}

	@Override
	public Optional<StatusLine> getStatusLine()
	{
		return Optional.of(statusLine);
	}

	@Override
	public Optional<MattpHeaders> getHeaders()
	{
		return Optional.of(headers);
	}

	@Override
	public Optional<T> getContent()
	{
		return Optional.ofNullable(body);
	}

	@Override
	public Optional<String> getErrorMessage()
	{
		return Optional.empty();
	}

}
