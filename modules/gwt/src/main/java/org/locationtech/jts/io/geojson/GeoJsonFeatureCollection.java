package org.locationtech.jts.io.geojson;

import java.util.List;

interface GeoJsonFeatureCollection extends GeoJsonObject {
	
	String TYPE = "FeatureCollection";

	public List<GeoJsonFeature> getFeatures();

	public void setFeatures(List<GeoJsonFeature> features);
}