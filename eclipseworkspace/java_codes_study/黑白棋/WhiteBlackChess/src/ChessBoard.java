import java.util.ArrayList;

public class ChessBoard {
	public static ArrayList<ChessPieces> cps = new ArrayList<>();
	static {
		for(int i = 0; i <64; i++){
			cps.add(new ChessPieces(i));
		}
		
	}
	public ChessBoard() {
		// TODO Auto-generated constructor stub
	}
}
