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

import java.util.List;

import com.google.web.bindery.autobean.shared.Splittable;

interface GeoJsonGeometry extends GeoJsonObject {
	
	String TYPE_POINT = "Point";
	String TYPE_LINE_STRING = "LineString";
	String TYPE_POLYGON = "Polygon";
	
	String TYPE_MULTI_POINT = "MultiPoint";
	String TYPE_MULTI_LINE_STRING = "MultiLineString";
	String TYPE_MULTI_POLYGON = "MultiPolygon";
	
	String TYPE_GEOMETRY_COLLECTION = "GeometryCollection";

	Splittable getCoordinates();
	void setCoordinates(Splittable coords);
	
	List<GeoJsonGeometry> getGeometries();
	void setGeometries(List<GeoJsonGeometry> geoms);
}
