package de.domisum.mattp.response.readers;

import de.domisum.lib.auxilium.util.java.annotations.API;
import de.domisum.mattp.response.MattpResponseBodyReader;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@API
@RequiredArgsConstructor
public class MattpStringReader implements MattpResponseBodyReader<String>
{

	// CONSTANTS
	@API
	public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	// SETTINGS
	private final Charset charset;


	// INIT
	@API
	public MattpStringReader()
	{
		charset = DEFAULT_CHARSET;
	}


	// READ
	@Override
	public String read(InputStream inputStream) throws IOException
	{
		return IOUtils.toString(inputStream, charset);
	}

}
