package example01;

public class NumberBox {
	private int ivalue;
	private float fvalue;
	private float result;
	
	public NumberBox(int ivalue, float fvalue) {
		this.ivalue = ivalue;
		this.fvalue = fvalue;
		this.result = 0.0f;
	}
	
	public void setIvalue(int ivalue) {
		this.ivalue = ivalue;
	}
	public void setFvalue(float fvalue) {
		this.fvalue = fvalue;
	}
	
	public int getIvalue() {
		return this.ivalue;
	}
	public float getFvalue() {
		return this.fvalue;
	}
	
	public float multy() {
		result = ivalue * fvalue;
		return result;
	}
}
