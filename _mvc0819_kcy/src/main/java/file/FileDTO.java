package file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class FileDTO {
	private int num;
	private String fname;
	private String ftime;
	private int fsize;
	
	public FileDTO(int num, String fname, String ftime, int fsize) {
		super();
		this.num = num;
		this.fname = fname;
		this.ftime = ftime;
		this.fsize = fsize;
	}
	@Override
	public String toString() {
		return "FileDTO [num=" + num + ", fname=" + fname + ", ftime=" + ftime + ", fsize=" + fsize + "]";
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFtime() {
		return ftime;
	}
	public void setFtime(String ftime) {
		this.ftime = ftime;
	}
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	
}
