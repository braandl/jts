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

public class GeometryCollection_CustomFieldSerializer extends CustomFieldSerializer<GeometryCollection>{

	public static boolean hasCustomInstantiate() {
		return true;
	}
	
	public static GeometryCollection instantiate(SerializationStreamReader streamReader)
			throws SerializationException {
		return (GeometryCollection) GeometrySerializer.instantiate(streamReader);
	}

	public static void deserialize(SerializationStreamReader streamReader,
			GeometryCollection instance) throws SerializationException {
		//deserialization is done during instantiation
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			GeometryCollection instance) throws SerializationException {
		GeometrySerializer.serialize(streamWriter, instance);
	}
	
	@Override
	public boolean hasCustomInstantiateInstance() {
		return hasCustomInstantiate();
	}
	
	@Override
	public GeometryCollection instantiateInstance(SerializationStreamReader streamReader)
			throws SerializationException {
		return instantiate(streamReader);
	}
	
	@Override
	public void deserializeInstance(SerializationStreamReader streamReader,
			GeometryCollection instance) throws SerializationException {
		deserialize(streamReader, instance);
	}

	@Override
	public void serializeInstance(SerializationStreamWriter streamWriter,
			GeometryCollection instance) throws SerializationException {
		serialize(streamWriter, instance);
	}

}
