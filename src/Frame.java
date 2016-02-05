
public class Frame 
{
	private boolean _isStrike;
	private boolean _isSpare;
	private int _value;
	private int _throw1;
	private int _throw2;
	
	public Frame()
	{
		this._isSpare=false;
		this._isStrike=false;
		this._throw1=0;
		this._throw2=0;
		this._value=0;
	}
	public void setThrow1(int t1)
	{
		this._throw1 = t1;
		if(this._throw1 == 10) // Strike
		{
			this._isStrike = true;
			this._value=10;
		}
	}
	
	public void setThrow2(int t2)
	{
		this._throw2 = t2;
		if(this._throw1 != 10 && this._throw1 + this._throw2 == 10) // Spare
		{
			this._isSpare = true;
		}
		else
			this._value = this._throw1 + this._throw2;
	}
	
	public boolean getStrike(){
		return this._isStrike;
	}
	
	public boolean getSpare(){
		return this._isSpare;
	}
	
	public int getValue(){
		return this._value;
	}
	
	public void setValue(int val)
	{
		this._value = val;
	}
	
}
