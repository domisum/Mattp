package de.domisum.mattp.request.bodies;

import de.domisum.lib.auxilium.mattp.request.MattpRequestBody;
import de.domisum.lib.auxilium.util.java.annotations.API;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@API
@RequiredArgsConstructor
public class MattpPlaintextBody implements MattpRequestBody
{

	// CONSTANTS
	private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;


	// ATTRIBUTES
	private final String text;
	private final Charset charset;


	// INIT
	@API
	public MattpPlaintextBody(String text)
	{
		this.text = text;
		charset = DEFAULT_CHARSET;
	}


	// BODY
	@Override public String getContentType()
	{
		return "text/plain";
	}

	@Override public InputStream getAsInputStream()
	{
		return IOUtils.toInputStream(text, charset);
	}

}
