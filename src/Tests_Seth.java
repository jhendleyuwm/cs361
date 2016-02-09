
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Tests_Seth{

	Bowl2 game;
	@Before
	public void setup(){
		game = new Bowl2();
	}
	
	@Test
	//- test a single throw and check scoring for the first frame and game
	public void testOneThrow(){
		try{
		game.addThrow(7);
		
		assertEquals(game.getScore(), 7);
		}
		catch(Exception e){
			assertFalse(e.getMessage() + " should not have thrown exception here", true);
		}
		
	} 
	
	@Test
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
	
	@Test
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
	
	@Test
	public void testSpareCountsNextFrameScore(){
		try{
			game.addThrow(7);
			game.addThrow(3);
			game.addThrow(3);
			game.addThrow(5);
			assertEquals(game.getScore(), 26);
			assertEquals(game.getFrame(1).getValue(), 18);
			}
			catch(Exception e){
				assertFalse("should not have thrown exception here", true);
			}
		
	} //- throw a spare in a frame and make sure its score is correct (counting the following frame, which should also be completed)
	
	@Test
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
	
	@Test
	public void testStrikeCountsNextFrameScores(){
		try{
		game.addThrow(10);
		game.addThrow(3);
		game.addThrow(5);
		game.addThrow(1);
		game.addThrow(4);
		assertEquals(game.getScore(), 36);
		assertEquals(game.getFrame(1).getValue(), 23);
		}
		catch(Exception e){
			assertFalse("should not have thrown exception here", true);
		}
	} //- throw a strike in a frame and make sure its score is correct (counting the following frames, which should also be completed)
	
	@Test
	public void testSpareOnLastFrame(){
		try{
		for(int i = 1; i<11; ++i){
			game.addThrow(0);
			game.addThrow(10);
			
		}
		assertEquals(190, game.getScore());
	}
	catch(Exception e){
		assertFalse("should not have thrown exception here", true);
	}
	} //- test throwing a spare on the 10th frame
	
	@Test
	public void testStrikeOnLastFrames(){
		try{
			for(int i = 1; i<11; ++i){
				game.addThrow(10);
				
			}
			assertEquals(270, game.getScore());
		}
		catch(Exception e){
			assertFalse("should not have thrown exception here", true);
		}
	} //- test throwing a strike on the 8th, 9th, and 10th frames
	
	@Test
	public void testThrowOn11thFrame(){
		boolean good = false;
		try{
			for(int i = 1; i<11; ++i){
				game.addThrow(0);
				game.addThrow(5);
				
			}
		}
		catch(Exception e){
			assertFalse("should not have thrown exception here", true);
		}
		try{
			
		}
		catch(Exception e){
			good = true;
		}
		assertTrue("11th frame should not be allowd", good);
	} //- ensure throwing on the 11th frame is not allowed (in some form)

}
