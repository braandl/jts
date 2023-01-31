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

import com.google.gwt.core.shared.GWT;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.Splittable;
import com.google.web.bindery.autobean.shared.impl.StringQuoter;

class GeoJsonUtils {

	private static GeoJsonFactory sFactory;
	
	private static void ensureFactory() {
		if(sFactory == null && GWT.isScript()) {
			sFactory = GWT.create(GeoJsonFactory.class);
		}
	}
	
	/*package*/ static void setFactory(GeoJsonFactory f) {
		sFactory = f;
	}
	
	public static GeoJsonCrs newCrs() {
		ensureFactory();
		
		return sFactory.crs().as();
	}
	
	public static GeoJsonGeometry newGeometry() {
		ensureFactory();
		
		return sFactory.geometry().as();
	}
	
	public static GeoJsonFeature newFeature() {
		ensureFactory();
		
		return sFactory.feature().as();
	}
	
	public static GeoJsonFeatureCollection newFeatureCollection() {
		ensureFactory();
		
		return sFactory.featureCollection().as();
	}
	
	public static Splittable decode(String payload) {
		return StringQuoter.split(payload);
	}
	
	public static GeoJsonGeometry decodeGeometry(Splittable data) {
		ensureFactory();
		
		return AutoBeanCodex.decode(sFactory, GeoJsonGeometry.class, data).as();
	}
	
	public static GeoJsonFeature decodeFeature(Splittable data) {
		ensureFactory();
		
		return AutoBeanCodex.decode(sFactory, GeoJsonFeature.class, data).as();
	}
	
	public static GeoJsonFeatureCollection decodeFeatureCollection(Splittable data) {
		ensureFactory();
		
		return AutoBeanCodex.decode(sFactory, GeoJsonFeatureCollection.class, data).as();
	}
}
