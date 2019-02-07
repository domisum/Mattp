package de.domisum.mattp.request;

import de.domisum.lib.auxilium.util.java.annotations.API;
import de.domisum.mattp.header.MattpHeader;
import de.domisum.mattp.header.MattpHeaders;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.List;

public class MattpRequest
{

	@Getter
	private final MattpMethod method;
	@Getter
	private final String url;

	private final List<MattpHeader> customHeaders = new ArrayList<>();

	@Getter
	private MattpRequestBody body;


	// INIT
	@API
	public MattpRequest(MattpMethod method, String url)
	{
		Validate.notNull(method, "method can't be null");
		Validate.notNull(url, "url can't be null");
		Validate.notEmpty(url, "url can't be empty");

		this.method = method;
		this.url = url;
	}


	// GETTERS
	@API
	public MattpHeaders getHeaders()
	{
		return new MattpHeaders(new ArrayList<>(customHeaders));
	}


	// SETTERS
	@API
	public void addHeader(CharSequence key, CharSequence value)
	{
		addHeader(new MattpHeader(key, value));
	}

	@API
	public void addHeader(MattpHeader header)
	{
		customHeaders.add(header);
	}

	@API
	public void setBody(MattpRequestBody body)
	{
		if(!method.allowsRequestBody())
			throw new IllegalStateException("can't add a request body to a request with a method that doesn't support bodies");

		this.body = body;
	}

}
