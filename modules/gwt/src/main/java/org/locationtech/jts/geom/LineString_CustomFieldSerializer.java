/*
 * Copyright (c) 2016 Vivid Solutions.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v20.html
 * and the Eclipse Distribution License is available at
 *
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.locationtech.jts.geom;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class LineString_CustomFieldSerializer extends CustomFieldSerializer<LineString>{

	public static boolean hasCustomInstantiate() {
		return true;
	}
	
	public static LineString instantiate(SerializationStreamReader streamReader)
			throws SerializationException {
		return (LineString) GeometrySerializer.instantiate(streamReader);
	}

	public static void deserialize(SerializationStreamReader streamReader,
			LineString instance) throws SerializationException {
		//deserialization is done during instantiation
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			LineString instance) throws SerializationException {
		GeometrySerializer.serialize(streamWriter, instance);
	}
	
	@Override
	public boolean hasCustomInstantiateInstance() {
		return hasCustomInstantiate();
	}
	
	@Override
	public LineString instantiateInstance(SerializationStreamReader streamReader)
			throws SerializationException {
		return instantiate(streamReader);
	}
	
	@Override
	public void deserializeInstance(SerializationStreamReader streamReader,
			LineString instance) throws SerializationException {
		deserialize(streamReader, instance);
	}

	@Override
	public void serializeInstance(SerializationStreamWriter streamWriter,
			LineString instance) throws SerializationException {
		serialize(streamWriter, instance);
	}

}
