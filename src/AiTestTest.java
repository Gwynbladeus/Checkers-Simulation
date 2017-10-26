import java.util.Random;

import checkers.Figure.FigureColor;
import checkers.GameLogic;
import checkers.Move;
import checkers.Player;
import generic.List;

public class AiTestTest implements Player {
	String name = "Test random Ai";
	List<Move> moveList;
	GameLogic gmlc;
	FigureColor aiFigureColor;
	Random rand;

	public AiTestTest(GameLogic pGmlc, boolean player1) {
		rand = new Random();
		moveList = new List<Move>();
		gmlc = pGmlc;
		if(player1) {
			aiFigureColor = gmlc.getColorForPlayer1();
		}
		else {
			aiFigureColor = gmlc.getColorForPlayer2();
		}
	}
	@Override
	public void prepare(FigureColor color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestMove() {
		moveList = Move.getPossibleMoves(aiFigureColor,gmlc.getPlayfield());
		int randomNumber = rand.nextInt(12)+1;
		moveList.toFirst();
		for(int i = 0;i < randomNumber; i++) {
			 if(moveList.hasAccess()) {
				 moveList.next();
			 }
			 else {
				 moveList.toFirst();
			 }
		}
		gmlc.makeMove(moveList.getContent());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean acceptDraw() {
		// TODO Auto-generated method stub
		return false;
	}

}
