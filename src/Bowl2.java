
public class Bowl2 {
	private Frame myFrames[] = new Frame[10];
	private int _currentIndex = 0, _currentThrow=1;
	public Bowl2(){}
	/**
	 * adds a single throw to current frame
	 * @param pinsDown
	 * @throws Exception
	 */
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
					updatePreviousFrame();
					_currentIndex++;
				}
				else{
					_currentThrow = 2;
				}
			}
			else{
				myFrames[_currentIndex].setThrow2(pinsDown);
				_currentThrow = 1;
				updatePreviousFrame();
				_currentIndex++;

			}
		}
	}
	/**
	 * updates the values of previous two frames if they are strikes or spares
	 */
	public void updatePreviousFrame()
	{

		if(_currentIndex > 0){

			
				Frame prev = myFrames[_currentIndex-1];
				Frame cur = myFrames[_currentIndex];
				Frame prevprev = null;
				if(_currentIndex>1){
					prevprev = myFrames[_currentIndex-2];
				}
				
				if(prev.getSpare() || prev.getStrike()){
					prev.setValue(prev.getPins()+cur.getPins());
				}
				if(prevprev != null && prevprev.getStrike()){
						prevprev.setValue(prevprev.getPins()+prev.getPins()+cur.getPins());
			}

		}
	}
	public int getScore(){
		int score = 0;
		for(int i=0; i<=_currentIndex && i<myFrames.length; ++i){
			if(myFrames[i] != null)
				score += myFrames[i].getValue();
		}
		return score;
	}
	public int getCurrentFrame(){
		return _currentIndex+1;
	}
	public Frame getFrame(int i){
		if(i<myFrames.length){
			return myFrames[i-1];
		}
		return null;
	}
}
