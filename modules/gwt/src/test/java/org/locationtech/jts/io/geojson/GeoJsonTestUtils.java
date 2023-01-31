package org.locationtech.jts.io.geojson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class GeoJsonTestUtils {
	public static String readGeoJsonFile(String name) throws IOException {
		InputStream is = GeoJsonReaderTest.class.getResourceAsStream(name
				+ ".geo.json");
		assert is != null;
		Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);

		StringBuilder sb = new StringBuilder();

		char[] cbuf = new char[1024];
		int len = -1;
		while ((len = r.read(cbuf)) != -1) {
			sb.append(cbuf, 0, len);
		}

		return sb.toString();
	}
}
