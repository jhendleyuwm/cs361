
public class Bowl2 {
	private Frame myFrames[] = new Frame[10];
	private int currentIndex = 0, currentThrow=1;
	public Bowl2()
	{

	}
	
	public void addThrow(int pinsDown) throws Exception
	{
		if (currentIndex>=10)
		{
			throw new Exception("too many turns");
		}
		else
		{
			if(currentThrow == 1){
				myFrames[currentIndex] = new Frame();
				myFrames[currentIndex].setThrow1(pinsDown);
				if(myFrames[currentIndex].getStrike()){
					currentIndex++;
				}
				else{
					currentThrow = 2;
				}
			}
			else{
				myFrames[currentIndex].setThrow2(pinsDown);
				currentThrow = 1;
				currentIndex++;
			}
			updatePreviousFrame();
		}
	}
	
	public void updatePreviousFrame()
	{
		if(currentIndex > 0){
			Frame prev = myFrames[currentIndex-1];
			Frame cur = myFrames[currentIndex];
			if(prev.getSpare()){
				prev.setValue(cur.getThrow1() + prev.getValue());
			}
			else if(prev.getStrike()){
				prev.setValue(cur.getPins() + prev.getValue());
			}
		}
	}
	public int getScore(){
		int score = 0;
		for(int i=0; i<myFrames.length; ++i){
			score += myFrames[i].getValue();
		}
		return score;
	}
	public int getCurrentFrame(){
		return currentIndex+1;
	}
}
