package networkClasses;

import java.awt.Graphics;

public class LoginResponse {
	private String responseText;
	private boolean isLogin;
	private int colorRGB;
	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public int getColorRGB() {
		return colorRGB;
	}

	public void setColorRGB(int colorRGB) {
		this.colorRGB = colorRGB;
	}
	public void draw(Graphics graphics){
		return ;
	}
}
