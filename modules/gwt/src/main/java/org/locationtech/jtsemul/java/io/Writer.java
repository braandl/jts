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

public abstract class Writer implements Appendable, Closeable, Flushable {

    protected Writer() {
    }
    
    protected Writer(Object o) {
    	this();
    }
	
    public void write(int c) throws IOException {

    }

    public void write(char chars[]) throws IOException {
        write(chars, 0, chars.length);
    }

    abstract public void write(char chars[], int off, int len) throws IOException;

    public void write(String str) throws IOException {

    }

    public void write(String str, int off, int len) throws IOException {

    }

    public Writer append(CharSequence csq) throws IOException {
    	return this;
    }

    public Writer append(CharSequence csq, int start, int end) throws IOException {
    	return this;
    }

    public Writer append(char c) throws IOException {
        return this;
    }

    abstract public void flush() throws IOException;

    abstract public void close() throws IOException;
}
