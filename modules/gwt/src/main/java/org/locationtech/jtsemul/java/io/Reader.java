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

public abstract class Reader implements /*Readable,*/ Closeable {

	protected Reader() {

	}

	public int read() throws IOException {
		char ca[] = new char[1];
		if (read(ca, 0, 1) == -1) {
			return -1;
		} else
			return ca[0];
	}

	public int read(char cbuf[]) throws IOException {
		return read(cbuf, 0, cbuf.length);
	}

	abstract public int read(char cbuf[], int off, int len) throws IOException;

	public long skip(long n) throws IOException {
		throw new UnsupportedOperationException("skip() not supported");
	}

	public boolean ready() throws IOException {
		return false;
	}

	public boolean markSupported() {
		return false;
	}

	public void mark(int readAheadLimit) throws IOException {
		throw new IOException("mark() not supported");
	}

	public void reset() throws IOException {
		throw new IOException("reset() not supported");
	}

	abstract public void close() throws IOException;
}