package de.domisum.mattp.request;

import java.io.InputStream;

public interface MattpRequestBody
{

	String getContentType();

	InputStream getAsInputStream();

}
