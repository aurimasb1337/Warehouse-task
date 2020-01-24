package lt.visma;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
private int quanity;
private long code;
private String name;
private Date expiration_date;


public Item(int quanity, long code, String name, String expiration_date) throws ParseException {
	this.quanity = quanity;
	this.code = code;
	this.name = name;
	this.expiration_date = format.parse(expiration_date);
}

public int getQuanity() {
	return quanity;
}
public void setQuanity(int quanity) {
	this.quanity = quanity;
}
public long getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getExpiration_date() {
	return expiration_date;
}
public void setExpiration_date(Date expiration_date) {
	this.expiration_date = expiration_date;
}


}
