package com.future.mqq.wxapi;

import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class Utils {

	/**
	 * ���32λ����
	 * 
	 * @return string
	 */
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	/**
	 * ����һ����ֵ�Ե�map,��������������sha1������Ҫ�����ַ�����userName=132134543,password=134566,
	 * ��ô�����map���Ǿ���map.put("userName"132134543),map.put("password",134566"),
	 */
	public static String getSingature(Map map) {
		Map newMap = sortMapByKey(map);
		Set set = newMap.keySet();
		if (set.size() == 0) {
			return null;
		} else {
			String x = "";
			Iterator it = set.iterator();
			while (it.hasNext()) {
				String key = it.next().toString();
				x = x + key;
				x = x + "=" + newMap.get(key).toString();
				x = x + "&";
			}

			// return x+Secret.getSignatureParam(Tools.getPackageSig());
			return x + "key=p762GrF1qyHmsahUzPvur9FLc0p6NMEG";
		}
	}

	/**
	 * ʹ�� Map��key��������
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, String> sortMap = new TreeMap<String, String>(
				new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}

	// �Ƚ�����
	private static class MapKeyComparator implements Comparator<String> {
		public int compare(String str1, String str2) {
			return str1.compareTo(str2);
		}
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * ת���ֽ�����Ϊ16�����ִ�
	 * 
	 * @param b
	 *            �ֽ�����
	 * @return 16�����ִ�
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuilder resultSb = new StringBuilder();
		for (byte aB : b) {
			resultSb.append(byteToHexString(aB));
		}
		return resultSb.toString();
	}

	/**
	 * ת��byte��16����
	 * 
	 * @param b
	 *            Ҫת����byte
	 * @return 16���Ƹ�ʽ
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5����
	 * 
	 * @param origin
	 *            ԭʼ�ַ�
	 * @return ����MD5����֮��Ľ��
	 */
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = origin;
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(resultString.getBytes("UTF-8"));
			resultString = byteArrayToHexString(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultString;
	}

}
