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

public class StringWriter extends Writer {

    private StringBuffer b;

    public StringWriter() {
        b = new StringBuffer();
    }

    public StringWriter(int capacity) {
        b = new StringBuffer(capacity);
    }

    public void write(int i) {
        b.append(i);
    }

    public void write(char cbuf[], int off, int len) {
        b.append(cbuf, off, len);
    }

    public void write(String str) {
        b.append(str);
    }

    public void write(String str, int off, int len)  {
        b.append(str.substring(off, off + len));
    }

    public StringWriter append(CharSequence s) {
        b.append(s);
        return this;
    }

    public StringWriter append(CharSequence s, int start, int end) {
        b.append(s, start, end);
        return this;
    }

    public StringWriter append(char c) {
        write(c);
        return this;
    }

    public String toString() {
        return b.toString();
    }

    public StringBuffer getBuffer() {
    	return b;
    }

    public void flush() {
    }

    public void close() throws IOException {
    }
}