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

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;

public abstract class GeometrySerializer {
	
	private static GeometryFactory sFactory = new GeometryFactory();
	private static WKBWriter sWriter = new WKBWriter(3, true);
	private static WKBReader sReader = new WKBReader(sFactory);
	
	public static GeometryFactory getFactory() {
		return sFactory;
	}
	
	public static void setFactory(GeometryFactory factory) {
		if(factory == null){
			throw new IllegalArgumentException();
		}
		
		sFactory = factory;
		sReader = new WKBReader(sFactory);
	}
	
	public static WKBReader getReader() {
		return sReader;
	}
	
	public static WKBWriter getWriter() {
		return sWriter;
	}
	
	public static boolean hasFactory() {
		return sFactory != null;
	}
	
	public static Geometry instantiate(SerializationStreamReader streamReader)
			throws SerializationException {
		WKBReader reader = sReader;
		
		String hex = streamReader.readString();
		byte[] wkb = WKBReader.hexToBytes(hex);
		
		
		try {
			Geometry g = reader.read(wkb);
			return g;
		} catch (ParseException e) {
			throw new SerializationException(e);
		}
	}

	public static void serialize(SerializationStreamWriter streamWriter,
			Geometry instance) throws SerializationException {
		WKBWriter writer = sWriter;
		
		byte[] wkb = writer.write(instance);
		String hex = WKBWriter.toHex(wkb);
		streamWriter.writeString(hex);
	}
}
