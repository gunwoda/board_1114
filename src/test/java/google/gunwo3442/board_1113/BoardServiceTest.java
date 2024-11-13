package google.gunwo3442.board_1113;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;
    @Test
    public void save_test() {
        int board_id = 2;
        String title = "test";
        String user_id = "test";
        String content = "test";
        String date = "1999-09-03";

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_id(board_id);
        boardDTO.setTitle(title);
        boardDTO.setUser_id(user_id);
        boardDTO.setContent(content);
        boardDTO.setDate(date);

        boardService.saveBoard(boardDTO);
        BoardDTO newBoardDTO = boardService.getBoardDTO(board_id);
        assertEquals(title, newBoardDTO.getTitle());
        boardService.deleteBoard(board_id);
    }

}
