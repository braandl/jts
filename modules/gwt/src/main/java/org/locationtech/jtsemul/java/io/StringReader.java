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
package java.io;

public class StringReader extends Reader {

	private char[] mChars;
	private int mLength;
	private int mNext = 0;

	public StringReader(String s) {
		if (s == null) {
			return;
		}

		mChars = s.toCharArray();
		mLength = mChars.length;
	}

	private void checkOpen() throws IOException {
		if (mChars == null)
			throw new IOException("stream is closed");
	}

	public int read() throws IOException {
		checkOpen();

		if (mNext >= mLength) {
			return -1;
		}

		char c = mChars[mNext];
		mNext++;

		return c;
	}

	public int read(char cbuf[], int off, int len) throws IOException {
		throw new UnsupportedOperationException("read() with buffer not supported");
	}

	public boolean ready() throws IOException {
		checkOpen();
		return true;
	}

	public void close() {
		mChars = null;
	}
}
