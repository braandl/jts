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

interface GeoJsonObject {

	public String getType();
	public void setType(String type);

	public GeoJsonCrs getCrs();
	public void setCrs(GeoJsonCrs crs);

	public List<Double> getBbox();
	public void setBbox(List<Double> bbox);
}
