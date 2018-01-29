package org.locationtech.jts.io.geojson;

import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.locationtech.jts.io.geojson.GeoJsonTestUtils.readGeoJsonFile;

public class GeoJsonReaderTest {

	private static GeoJsonReader sReader;
	private static WKTReader sWkt;

	//@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GeoJsonUtils.setFactory(AutoBeanFactorySource
				.create(GeoJsonFactory.class));
		sReader = new GeoJsonReader();
		sWkt = new WKTReader(sReader.getGeometryFactory());
	}

	//@Test
	public void itShouldReadPoint() throws IOException, ParseException {
		
		Point p = (Point) sReader.read(readGeoJsonFile("point1"));
		assertEquals(10, p.getX(), 0);
		assertEquals(20, p.getY(), 0);
		//assertEquals(Double.NaN, p.getZ(), 0);
		
		p = (Point) sReader.read(readGeoJsonFile("point2"));
		assertEquals(10, p.getX(), 0);
		assertEquals(20, p.getY(), 0);
		//assertEquals(30, p.getZ(), 0);
	}
	
	//@Test(expected = ParseException.class)
	public void itShouldReadEmptyCoords() throws IOException, ParseException {
		sReader.read(readGeoJsonFile("point3"));
	}

	//@Test
	public void itShouldReadLineString() throws IOException, ParseException {
		LineString actual = (LineString) sReader.read(readGeoJsonFile("line1"));
		LineString expected = (LineString) sWkt.read("LINESTRING (10 20, 30 40, 50 60)");
		
		assertEquals(expected, actual);
		
		actual = (LineString) sReader.read(readGeoJsonFile("line2"));
		expected = (LineString) sWkt.read("LINESTRING (10 20 30, 30 40 50, 50 60 70)");
		
		assertEquals(expected, actual);
		
		actual = (LineString) sReader.read(readGeoJsonFile("line3"));
		expected = (LineString) sWkt.read("LINESTRING EMPTY");
		
		assertEquals(expected, actual);
	}
}
