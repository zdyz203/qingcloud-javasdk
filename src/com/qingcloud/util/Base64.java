package com.qingcloud.util;

import java.io.*;

/**
 * Base64 decode & encode
 * Reference from http://www.sauronsoftware.it
 * License: LGPL v2.1
 */
class Base64 {
	
	private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	private static final char PAD = '=';
	
	private static class Base64InputStream extends InputStream {
		/**
		 * The underlying stream.
		 */
		private InputStream inputStream;

		/**
		 * The buffer.
		 */
		private int[] buffer;

		/**
		 * A counter for values in the buffer.
		 */
		private int bufferCounter = 0;

		/**
		 * End-of-stream flag.
		 */
		private boolean eof = false;

		/**
		 * <p>
		 * It builds a base64 decoding input stream.
		 * </p>
		 * 
		 * @param inputStream
		 *            The underlying stream, from which the encoded data is read.
		 */
		public Base64InputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		public int read() throws IOException {
			if (buffer == null || bufferCounter == buffer.length) {
				if (eof) {
					return -1;
				}
				acquire();
				if (buffer.length == 0) {
					buffer = null;
					return -1;
				}
				bufferCounter = 0;
			}
			return buffer[bufferCounter++];
		}

		/**
		 * Reads from the underlying stream, decodes the data and puts the decoded
		 * bytes into the buffer.
		 */
		private void acquire() throws IOException {
			char[] four = new char[4];
			int i = 0;
			do {
				int b = inputStream.read();
				if (b == -1) {
					if (i != 0) {
						throw new IOException("Bad base64 stream");
					} else {
						buffer = new int[0];
						eof = true;
						return;
					}
				}
				char c = (char) b;
				if (CHARS.indexOf(c) != -1 || c == PAD) {
					four[i++] = c;
				} else if (c != '\r' && c != '\n') {
					throw new IOException("Bad base64 stream");
				}
			} while (i < 4);
			boolean padded = false;
			for (i = 0; i < 4; i++) {
				if (four[i] != PAD) {
					if (padded) {
						throw new IOException("Bad base64 stream");
					}
				} else {
					if (!padded) {
						padded = true;
					}
				}
			}
			int l;
			if (four[3] == PAD) {
				if (inputStream.read() != -1) {
					throw new IOException("Bad base64 stream");
				}
				eof = true;
				if (four[2] == PAD) {
					l = 1;
				} else {
					l = 2;
				}
			} else {
				l = 3;
			}
			int aux = 0;
			for (i = 0; i < 4; i++) {
				if (four[i] != PAD) {
					aux = aux | (CHARS.indexOf(four[i]) << (6 * (3 - i)));
				}
			}
			buffer = new int[l];
			for (i = 0; i < l; i++) {
				buffer[i] = (aux >>> (8 * (2 - i))) & 0xFF;
			}
		}

		public void close() throws IOException {
			inputStream.close();
		}
	}
	
	private static class Base64OutputStream extends OutputStream {

		/**
		 * The underlying stream.
		 */
		private OutputStream outputStream = null;

		/**
		 * A value buffer.
		 */
		private int buffer = 0;

		/**
		 * How many bytes are currently in the value buffer?
		 */
		private int bytecounter = 0;

		/**
		 * A counter for the current line length.
		 */
		private int linecounter = 0;

		/**
		 * The requested line length.
		 */
		private int linelength = 0;

		/**
		 * <p>
		 * It builds a base64 encoding output stream writing the encoded data in the
		 * given underlying stream.
		 * </p>
		 * 
		 * <p>
		 * The encoded data is wrapped to a new line (with a CRLF sequence) every 76
		 * bytes sent to the underlying stream.
		 * </p>
		 * 
		 * @param outputStream
		 *            The underlying stream.
		 */
		public Base64OutputStream(OutputStream outputStream) {
			this(outputStream, 76);
		}

		/**
		 * <p>
		 * It builds a base64 encoding output stream writing the encoded data in the
		 * given underlying stream.
		 * </p>
		 * 
		 * <p>
		 * The encoded data is wrapped to a new line (with a CRLF sequence) every
		 * <em>wrapAt</em> bytes sent to the underlying stream. If the
		 * <em>wrapAt</em> supplied value is less than 1 the encoded data will not
		 * be wrapped.
		 * </p>
		 * 
		 * @param outputStream
		 *            The underlying stream.
		 * @param wrapAt
		 *            The max line length for encoded data. If less than 1 no wrap
		 *            is applied.
		 */
		public Base64OutputStream(OutputStream outputStream, int wrapAt) {
			this.outputStream = outputStream;
			this.linelength = wrapAt;
		}

		public void write(int b) throws IOException {
			int value = (b & 0xFF) << (16 - (bytecounter * 8));
			buffer = buffer | value;
			bytecounter++;
			if (bytecounter == 3) {
				commit();
			}
		}

		public void close() throws IOException {
			commit();
			outputStream.close();
		}

		/**
		 * <p>
		 * It commits 4 bytes to the underlying stream.
		 * </p>
		 */
		protected void commit() throws IOException {
			if (bytecounter > 0) {
				if (linelength > 0 && linecounter == linelength) {
					outputStream.write("\r\n".getBytes());
					linecounter = 0;
				}
				char b1 = CHARS.charAt((buffer << 8) >>> 26);
				char b2 = CHARS.charAt((buffer << 14) >>> 26);
				char b3 = (bytecounter < 2) ? PAD : CHARS.charAt((buffer << 20) >>> 26);
				char b4 = (bytecounter < 3) ? PAD : CHARS.charAt((buffer << 26) >>> 26);
				outputStream.write(b1);
				outputStream.write(b2);
				outputStream.write(b3);
				outputStream.write(b4);
				linecounter += 4;
				bytecounter = 0;
				buffer = 0;
			}
		}

	}
	
	
	public static String encode(String str) throws RuntimeException {
		byte[] bytes = str.getBytes();
		byte[] encoded = encode(bytes);
		try {
			return new String(encoded, "ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
	}
	
	public static String encode(String str, String charset)
			throws RuntimeException {
		byte[] bytes;
		try {
			bytes = str.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Unsupported charset: " + charset, e);
		}
		byte[] encoded = encode(bytes);
		try {
			return new String(encoded, "ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
	}
	
	public static String decode(String str) throws RuntimeException {
		byte[] bytes;
		try {
			bytes = str.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
		byte[] decoded = decode(bytes);
		return new String(decoded);
	}
	
	public static String decode(String str, String charset)
			throws RuntimeException {
		byte[] bytes;
		try {
			bytes = str.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("ASCII is not supported!", e);
		}
		byte[] decoded = decode(bytes);
		try {
			return new String(decoded, charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Unsupported charset: " + charset, e);
		}
	}
	
	public static byte[] encode(byte[] bytes) throws RuntimeException {
		return encode(bytes, 0);
	}
	
	public static byte[] encode(byte[] bytes, int wrapAt)
			throws RuntimeException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			encode(inputStream, outputStream, wrapAt);
		} catch (IOException e) {
			throw new RuntimeException("Unexpected I/O error", e);
		} finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
			try {
				outputStream.close();
			} catch (Throwable t) {
				;
			}
		}
		return outputStream.toByteArray();
	}
	
	public static byte[] decode(byte[] bytes) throws RuntimeException {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			decode(inputStream, outputStream);
		} catch (IOException e) {
			throw new RuntimeException("Unexpected I/O error", e);
		} finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
				;
			}
			try {
				outputStream.close();
			} catch (Throwable t) {
				;
			}
		}
		return outputStream.toByteArray();
	}
	
	public static void encode(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		encode(inputStream, outputStream, 0);
	}
	
	public static void encode(InputStream inputStream,
			OutputStream outputStream, int wrapAt) throws IOException {
		Base64OutputStream aux = new Base64OutputStream(outputStream, wrapAt);
		copy(inputStream, aux);
		aux.commit();
	}
	
	public static void decode(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		copy(new Base64InputStream(inputStream), outputStream);
	}
	
	public static void encode(File source, File target, int wrapAt)
			throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(target);
			Base64.encode(inputStream, outputStream, wrapAt);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Throwable t) {
					;
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Throwable t) {
					;
				}
			}
		}
	}
	
	public static void encode(File source, File target) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(target);
			Base64.encode(inputStream, outputStream);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Throwable t) {
					;
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Throwable t) {
					;
				}
			}
		}
	}
	
	public static void decode(File source, File target) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(target);
			decode(inputStream, outputStream);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (Throwable t) {
					;
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Throwable t) {
					;
				}
			}
		}
	}
	
	private static void copy(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// 1KB buffer
		byte[] b = new byte[1024];
		int len;
		while ((len = inputStream.read(b)) != -1) {
			outputStream.write(b, 0, len);
		}
	}
}
