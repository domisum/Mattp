package de.domisum.mattp.response.readers;

import de.domisum.lib.auxilium.contracts.serialization.ToStringSerializer;
import de.domisum.lib.auxilium.mattp.response.MattpResponseBodyReader;
import de.domisum.lib.auxilium.mattp.response.readers.MattpStringReader;
import de.domisum.lib.auxilium.util.java.annotations.API;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;

@API
@RequiredArgsConstructor
public class MattpSerializedObjectReader<T> implements MattpResponseBodyReader<T>
{

	private final MattpResponseBodyReader<String> stringReader;
	private final ToStringSerializer<T> toStringSerializer;


	// INIT
	public MattpSerializedObjectReader(ToStringSerializer<T> toStringSerializer)
	{
		stringReader = new MattpStringReader();
		this.toStringSerializer = toStringSerializer;
	}


	// READ
	@Override public T read(InputStream inputStream) throws IOException
	{
		String serialized = stringReader.read(inputStream);

		try
		{
			T object = toStringSerializer.deserialize(serialized);

			if(object == null)
				throw new IOException("deserialized object was null (json input: "+serialized+")");

			return object;
		}
		catch(RuntimeException e)
		{
			throw new IOException("failed to deserialize object: "+serialized, e);
		}
	}

}
