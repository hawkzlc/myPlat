package com.yihaomen.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.junit.Test;

/**
 * 默认对象序列化工具
 * 
 * @author chenlei
 *
 */
public class DefaultObjectSerializer implements Serializable {
	// 设置触发压缩的阈值
	protected static final int DEFAULT_COMPRESSION_THRESHOLD = 16384;
	protected int compressionThreshold = 16384;

	public DefaultObjectSerializer() {
	}

	public int getCompressionThreshold() {
		return this.compressionThreshold;
	}

	protected byte[] doSerialize(Object o) {
		if (o == null) {
			return null;
		} else {
			Object rv = null;
			ByteArrayOutputStream bos = null;
			ObjectOutputStream os = null;

			byte[] rv1;
			try {
				bos = new ByteArrayOutputStream();
				os = new ObjectOutputStream(bos);
				os.writeObject(o);
				os.close();
				bos.close();
				rv1 = bos.toByteArray();
			} catch (IOException var16) {
				throw new IllegalArgumentException("Non-serializable object.", var16);
			} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (IOException var15) {
					;
				}

				try {
					if (bos != null) {
						bos.close();
					}
				} catch (IOException var14) {
					;
				}

			}

			return rv1;
		}
	}

	protected Object doDeserialize(byte[] in) {
		if (in == null) {
			return null;
		} else {
			Object rv = null;
			ByteArrayInputStream bis = null;
			ObjectInputStream is = null;

			try {
				bis = new ByteArrayInputStream(in);
				is = new ObjectInputStream(bis);
				rv = is.readObject();
				is.close();
				bis.close();
			} catch (Exception var16) {
				throw new IllegalArgumentException("Can\'t-deserialize object", var16);
			} finally {
				try {
					if (is != null) {
						is.close();
					}
				} catch (IOException var15) {
					;
				}

				try {
					if (bis != null) {
						bis.close();
					}
				} catch (IOException var14) {
					;
				}

			}

			return rv;
		}
	}

	/**
	 * 对字节长度超出阈值的进行gzip压缩
	 */
	protected byte[] compress(byte[] in) {
		if (in == null) {
			return null;
		} else {
			Object rv = null;
			ByteArrayOutputStream bos = null;
			GZIPOutputStream gz = null;

			byte[] rv1;
			try {
				bos = new ByteArrayOutputStream();
				gz = new GZIPOutputStream(bos);
				gz.write(in);
				rv1 = bos.toByteArray();
				gz.close();
				bos.close();
			} catch (IOException var16) {
				throw new IllegalArgumentException("IO exception compressing data.", var16);
			} finally {
				try {
					if (gz != null) {
						gz.close();
					}
				} catch (IOException var15) {
					;
				}

				try {
					if (bos != null) {
						bos.close();
					}
				} catch (IOException var14) {
					;
				}

			}

			return rv1;
		}
	}

	/*
	 * 对经过压缩的字节数组进行解压缩
	 */
	protected byte[] decompress(byte[] in) {
		if (in == null) {
			return null;
		} else {
			Object rv = null;
			ByteArrayOutputStream bos = null;
			ByteArrayInputStream bis = null;
			GZIPInputStream gis = null;

			try {
				bis = new ByteArrayInputStream(in);
				gis = new GZIPInputStream(bis);
				bos = new ByteArrayOutputStream();
				byte[] e = new byte[8192];
				boolean r = true;

				int r1;
				while ((r1 = gis.read(e)) > 0) {
					bos.write(e, 0, r1);
				}

				byte[] rv1 = bos.toByteArray();
				gis.close();
				bos.close();
				return rv1;
			} catch (IOException var21) {
				throw new IllegalArgumentException("IO exception decompress data.", var21);
			} finally {
				try {
					if (gis != null) {
						gis.close();
					}
				} catch (IOException var20) {
					;
				}

				try {
					if (bis != null) {
						bis.close();
					}
				} catch (IOException var19) {
					;
				}

				try {
					if (bos != null) {
						bos.close();
					}
				} catch (IOException var18) {
					;
				}

			}
		}
	}

	/**
	 * 对object进行序列化
	 */
	public byte[] serialize(Object obj) throws Exception {
		try {
			Object ex = null;
			byte[] ex1 = this.doSerialize(obj);
			if (ex1 == null) {
				return null;
			} else {
				if (ex1.length > this.compressionThreshold) {
					ex1 = this.compress(ex1);
				}

				return ex1;
			}
		} catch (Exception var3) {
			throw var3;
		}
	}

	/**
	 * 对object进行反序列化,返回对应的类实例
	 */
	public Object deserialize(byte[] bytes) throws Exception {
		Object rawValue = null;

		byte[] rawValue1;
		try {
			rawValue1 = this.decompress(bytes);
		} catch (Exception var5) {
			rawValue1 = bytes;
		}

		try {
			return this.doDeserialize(rawValue1);
		} catch (Exception var4) {
			throw var4;
		}
	}
	
	@Test
	public void testCompress(){
		String string="this is a test sentence,please read it....";
		DefaultObjectSerializer defaultObjectSerializer=new DefaultObjectSerializer();
		try {
			byte[] op= defaultObjectSerializer.serialize(string);
			String s=(String) defaultObjectSerializer.deserialize(op);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
