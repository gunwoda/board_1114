package google.gunwo3442.board_1113;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;
    @Test
    public void save_test() {
        String title = "test";
        String user_id = "test";
        String content = "test";
        String date = "1999-09-03";

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setUser_id(user_id);
        boardDTO.setContent(content);
        boardDTO.setDate(date);

        int board_id = boardService.saveBoard(boardDTO);
        BoardDTO newBoardDTO = boardService.getBoardDTO(board_id);
        assertEquals(title, newBoardDTO.getTitle());
        boardService.deleteBoard(boardDTO.getBoard_id());
    }

}
