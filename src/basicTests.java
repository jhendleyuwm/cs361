

public class basicTests {
	public void testOneThrow(){} //- test a single throw and check scoring for the first frame and game
	public void testTwoThrows(){} //- test two throws and check scoring for the first frame and game
	public void testThreeThrows(){} //- test three throws and check scoring for the first two frames and game
	public void testSpareCountsNextFrameScore(){} //- throw a spare in a frame and make sure its score is correct (counting the following frame, which should also be completed)
	public void testStrikeMovesToNextFrame(){} //- ensure that a strike frame may not have two throws
	public void testStrikeCountsNextFrameScores(){} //- throw a strike in a frame and make sure its score is correct (counting the following frames, which should also be completed)
	public void testSpareOnLastFrame(){} //- test throwing a spare on the 10th frame
	public void testStrikeOnLastFrames(){} //- test throwing a strike on the 8th, 9th, and 10th frames
	public void testThrowOn11thFrame(){} //- ensure throwing on the 11th frame is not allowed (in some form)
}
