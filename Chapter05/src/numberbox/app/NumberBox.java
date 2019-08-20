package numberbox.app;

public class NumberBox {
	private int ivalue;
	private float fvalue;
	private double dvalue;
	private char cvalue;
	
	public NumberBox() {
		this.ivalue = 0;
		this.fvalue = 0.0f;
		this.dvalue = 0.0;
		this.cvalue = 0;
	}
	
	public NumberBox(int ivalue, float fvalue, double dvalue) {
		this.ivalue = ivalue;
		this.fvalue = fvalue;
		this.dvalue = dvalue;
		this.cvalue = 0;
	}
	
	public NumberBox(int ivalue, float fvalue, double dvalue, char cvalue) {
		this.ivalue = ivalue;
		this.fvalue = fvalue;
		this.dvalue = dvalue;
		this.cvalue = cvalue;
	}

	public int getIvalue() {
		return ivalue;
	}

	public void setIvalue(int ivalue) {
		this.ivalue = ivalue;
	}

	public float getFvalue() {
		return fvalue;
	}

	public void setFvalue(float fvalue) {
		this.fvalue = fvalue;
	}

	public double getDvalue() {
		return dvalue;
	}

	public void setDvalue(double dvalue) {
		this.dvalue = dvalue;
	}

	public char getCvalue() {
		return cvalue;
	}

	public void setCvalue(char cvalue) {
		this.cvalue = cvalue;
	}
	
	public float calculate(int ivalue, float fvalue) {
		this.ivalue = this.ivalue + ivalue;
		this.fvalue = this.fvalue +fvalue;
		
		return this.ivalue * this.fvalue;
	}
	
	public double calculate(int ivalue, float fvalue, double dvalue) {
		this.ivalue = this.ivalue + ivalue;
		this.fvalue = this.fvalue +fvalue;
		this.dvalue = this.dvalue + dvalue;
		
		return this.ivalue + this.fvalue + this.dvalue;
	}

	@Override
	public String toString() {
		return "NumberBox [ivalue=" + ivalue + ", fvalue=" + fvalue + ", dvalue=" + dvalue + ", cvalue=" + cvalue + "]";
	}
	
	
	
}
