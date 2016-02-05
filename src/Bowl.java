
public class Bowl {
	private Frame myFrames[] = new Frame[10];
	
	public Bowl()
	{

	}
	
	public void throwTurn(int turnNumber, int pinsDown) throws Exception
	{
		if (turnNumber>20)
		{
			throw new Exception("to many turns");
		}
		else
		{
			if (turnNumber%2==1)
			{
				myFrames[turnNumber/2].setThrow1(pinsDown);
			}
			else
			{
				myFrames[turnNumber/2].setThrow2(pinsDown);
			}
				
		}
	}
	
	public void updateScore(Frame frame[])
	{
		if (frame[9].getSpare() || frame[9].getStrike())
		{
		frame[9].setValue(frame[9].getPins()+frame[10].getValue());
		}
		
		
	}
	
	
}
