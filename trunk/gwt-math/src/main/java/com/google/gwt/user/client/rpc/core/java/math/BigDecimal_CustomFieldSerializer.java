package com.google.gwt.user.client.rpc.core.java.math;
//FUNZIA
//com.google.gwt.user.client.rpc.core.java.math

//NO
//com.googlecode.gwt.math.client.rpc.core.java.math
//com.mycompany.project.client.rpc.core.java.math
import java.math.BigDecimal;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class BigDecimal_CustomFieldSerializer {

	public static void deserialize(SerializationStreamReader streamReader,
			BigDecimal instance) {

	}

	public static BigDecimal instantiate(SerializationStreamReader streamReader)
			throws SerializationException {
		return new BigDecimal(streamReader.readString());
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			BigDecimal instance) throws SerializationException {
		streamWriter.writeString(instance.toString());
	}
}
