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
package org.locationtech.jts.util;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.i18n.client.constants.NumberConstants;

/**
 * Abstracts away access to formatting classes. In JVM compiled class is used
 * which uses j.t.DecimalFormat. In GWT this implementation is used
 *
 */
public class NumberFormat {
	private com.google.gwt.i18n.client.NumberFormat mFormat;
	private String mGrouping;
	private String mDecimal;
	
	private NumberFormat() {
		
	}
	
	public static NumberFormat getFormat(String pattern) {
	    NumberFormat nf = new NumberFormat();
		
	    NumberConstants nc = LocaleInfo.getCurrentLocale().getNumberConstants();
	    
	    nf.mFormat = com.google.gwt.i18n.client.NumberFormat.getFormat(pattern);
	    nf.mGrouping = nc.groupingSeparator();
	    nf.mDecimal = nc.decimalSeparator();
	    
	    return nf;
	}

	public String format(Number n) {
		String s = mFormat.format(n);
		
		if(!mGrouping.equals("")) {
			s = s.replace(mGrouping, "");
		}
		
		if(!mDecimal.equals(".")) {
			s = s.replace(mGrouping, ".");
		}
		
		return s;
	}
}
