
public class Bowl2 {
	private Frame myFrames[] = new Frame[10];
	private int _currentIndex = 0, _currentThrow=1;
	public Bowl2()
	{

	}
	
	public void addThrow(int pinsDown) throws Exception
	{
		if(pinsDown>10 || pinsDown<0){
			throw new Exception("pins must be between 0 and 10");
		}
		if (_currentIndex>=10)
		{
			throw new Exception("too many turns");
		}
		else
		{
			if(_currentThrow == 1){
				myFrames[_currentIndex] = new Frame();
				myFrames[_currentIndex].setThrow1(pinsDown);
				if(myFrames[_currentIndex].getStrike()){
					_currentIndex++;
				}
				else{
					_currentThrow = 2;
				}
			}
			else{
				if(_currentIndex==9&&myFrames[9].getStrike()){
					
				}
				myFrames[_currentIndex].setThrow2(pinsDown);
				_currentThrow = 1;
				_currentIndex++;
				
				
			}
			updatePreviousFrame();
		}
	}
	
	public void updatePreviousFrame()
	{
		if(myFrames.length > 0){
			
				for(int i=myFrames.length;i>0; i--){
					Frame prev = myFrames[i-1];
					Frame cur = myFrames[i];
					if(prev.getSpare()){
						prev.setValue(prev.getThrow1()+cur.getValue());;
					}
					else if(prev.getStrike()){
						
						if(i+1<myFrames.length){
							prev.setValue(prev.getPins()+ cur.getValue() + myFrames[i+1].getValue());
						}
						else
							prev.setValue(prev.getPins()+cur.getValue());
						
					}
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
		return _currentIndex+1;
	}
	public Frame getFrame(int i){
		if(i<myFrames.length){
			return myFrames[i];
		}
		return null;
	}
}
