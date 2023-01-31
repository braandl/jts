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
package org.locationtech.jts.io.geojson;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.OutStream;

public class GeoJsonWriter {

	public GeoJsonWriter() {
		this(2);
	}
	
	public GeoJsonWriter(int outputDimension) {
		this(outputDimension, false, false);
	}
	
	public GeoJsonWriter(int outputDimension, boolean includeCrs, boolean includeBbox) {
		
	}
	
	public String write(Geometry geometry) {
		return null;
	}
	
	public void write(Geometry geometry, OutStream output) {
		
	}
	
	public String write(GeoJsonObject object) {
		return null;
	}
	
	public void write(GeoJsonObject object, OutStream output) {
		
	}
}
