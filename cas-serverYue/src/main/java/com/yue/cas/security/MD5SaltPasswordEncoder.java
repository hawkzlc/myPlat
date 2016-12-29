package com.yue.cas.security;


import org.jasig.cas.authentication.handler.PasswordEncoder;
import org.springframework.util.DigestUtils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MD5SaltPasswordEncoder implements PasswordEncoder {
	private String salt;
	private String maskcode;

	public String getSalt() {
		return salt;
	}


	public MD5SaltPasswordEncoder(String salt, String maskcode) {
		super();
		this.salt = salt;
		this.maskcode = maskcode;
	}



	public void setSalt(String salt) {

		this.salt = salt;

	}

	@Override
	public String encode(final String password) {
		String saltme = createSalt(password);
		
		return MD51(MD51(password) + saltme);

	}

	public String createSalt(String password) {
		String saltme = "";
		String maskstr="";
		if(!isNumeric(this.maskcode)){
			maskstr="19790901";
		}else if (this.maskcode.length()>password.length()) {
			maskstr=this.maskcode.substring(0, password.length()-1);
		} else{
			maskstr=this.maskcode;
		}
		for(int i=0;i<maskstr.length();i++){
			if (Integer.parseInt(maskstr.substring(i, i+1))>0){
				saltme=saltme+password.substring(i,i+1);
			}
		}
		return saltme;

	}

	public MD5SaltPasswordEncoder() {
		super();
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public String MD51(String password) {
		return DigestUtils.md5DigestAsHex(password.getBytes());
	}

	

	public String getMaskcode() {
		return maskcode;
	}

	public void setMaskcode(String maskcode) {
		this.maskcode = maskcode;
	}

}