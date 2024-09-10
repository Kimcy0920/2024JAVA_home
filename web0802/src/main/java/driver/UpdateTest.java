package driver;

import board.BoardDAO;
import board.BoardDTO;

public class UpdateTest {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(12, "김판용", "나의 오늘 하루", "학생들에게 손흥민 썰 풀기", null, 0);
		dao.updateBoard(dto);

	}

}
