package entidad;

public class Cifrador {
		//retorna un hash apetir de un tipo y un texto
		public static String getCifrador(String txt, String hashType) {
			try {
				java.security.MessageDigest md= java.security.MessageDigest.getInstance(hashType);
				byte[] array = md.digest(txt.getBytes());
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<array.length;++i) {
					sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
				}
				return sb.toString();
			} catch (java.security.NoSuchAlgorithmException e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		//retorna un hash MD5 a partir de un etxto
		public static String md5(String txt) {
			return Cifrador.getCifrador(txt,"MD5");
		}
		//retorna un hash SHA1 a partir de un texto
		public static String sha1(String txt) {
			return Cifrador.getCifrador(txt,"SHA1");
		}
}
