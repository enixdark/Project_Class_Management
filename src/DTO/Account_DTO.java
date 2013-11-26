package DTO;

public class Account_DTO {
	private String user;
	private String pass;
	private int level;
	private byte[] image; 
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Account_DTO(){
		
	}
	public Account_DTO(String user){
		this(user,"",0);
	}
	public Account_DTO(String user,String pass){
		this(user,pass,0);
	}
	
	public Account_DTO(String user,String pass,int level)
	{
		this.user = user;
		this.pass = pass;
		this.level = level;
	}
	public Account_DTO(String user,String pass,int level,byte[] image)
	{
		this.user = user;
		this.pass = pass;
		this.level = level;
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
