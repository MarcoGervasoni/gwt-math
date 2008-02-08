package com.google.gwt.user.client.rpc.core.java.math;
//FUNZIA
//com.google.gwt.user.client.rpc.core.java.math

//NO
//com.googlecode.gwt.math.client.rpc.core.java.math
//com.mycompany.project.client.rpc.core.java.math
import java.math.BigInteger;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class BigInteger_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader,
			BigInteger instance) {

	}

	public static BigInteger instantiate(SerializationStreamReader streamReader)
			throws SerializationException {
		return new BigInteger(streamReader.readString());
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			BigInteger instance) throws SerializationException {
		streamWriter.writeString(instance.toString());
	}
}
