package game;

public class TicTacToe extends Game {
	
	public TicTacToe(String player1, String player2)
	{//game x o, 2 players one with 'x' and other with 'y'
		super(3,3,new Player (player1,'X'),new Player(player2,'O'));
		
	}
	@Override
	protected boolean doesWin(int x, int y) 
	{//if someone has line with 3 marks o or x
		if(maxLineContaining(x,y)==3) return true;
		return false;
		
	}
}


