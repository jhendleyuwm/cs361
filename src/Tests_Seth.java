
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class Tests_Seth{

	Bowl2 game;
	@Before
	private void setup(){
		game = new Bowl2();
	}
	//- test a single throw and check scoring for the first frame and game
	public void testOneThrow(){
		try{
		game.addThrow(7);
		assertEquals(game.getScore(), 7);
		}
		catch(Exception e){
			assertFalse("should not have thrown exception here", true);
		}
		
	} 
	public void testTwoThrows(){
		try{
			game.addThrow(7);
			game.addThrow(2);
			assertEquals(game.getScore(), 4);
			}
			catch(Exception e){
				assertFalse("should not have thrown exception here", true);
			}
			
	} //- test two throws and check scoring for the first frame and game
	public void testThreeThrows(){
		try{
			game.addThrow(7);
			game.addThrow(2);
			game.addThrow(3);
			assertEquals(game.getScore(), 12);
			}
			catch(Exception e){
				assertFalse("should not have thrown exception here", true);
			}
			
	} //- test three throws and check scoring for the first two frames and game
	public void testSpareCountsNextFrameScore(){
		try{
			game.addThrow(7);
			game.addThrow(3);
			game.addThrow(3);
			game.addThrow(5);
			assertEquals(game.getScore(), 21);
			assertEquals(game.getFrame(1).getValue(), 13);
			}
			catch(Exception e){
				assertFalse("should not have thrown exception here", true);
			}
		
	} //- throw a spare in a frame and make sure its score is correct (counting the following frame, which should also be completed)
	public void testStrikeMovesToNextFrame(){
		try{
			assertEquals(game.getCurrentFrame(),1);
			game.addThrow(10);
			assertEquals(game.getCurrentFrame(),2);
			}
			catch(Exception e){
				assertFalse("should not have thrown exception here", true);
			}
	} //- ensure that a strike frame may not have two throws
	public void testStrikeCountsNextFrameScores(){
		try{
		game.addThrow(10);
		game.addThrow(3);
		game.addThrow(5);
		assertEquals(game.getScore(), 26);
		assertEquals(game.getFrame(1).getValue(), 18);
		}
		catch(Exception e){
			assertFalse("should not have thrown exception here", true);
		}
	} //- throw a strike in a frame and make sure its score is correct (counting the following frames, which should also be completed)
	public void testSpareOnLastFrame(){} //- test throwing a spare on the 10th frame
	public void testStrikeOnLastFrames(){} //- test throwing a strike on the 8th, 9th, and 10th frames
	public void testThrowOn11thFrame(){} //- ensure throwing on the 11th frame is not allowed (in some form)

}
