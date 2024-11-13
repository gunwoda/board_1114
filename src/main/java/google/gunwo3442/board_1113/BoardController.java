package google.gunwo3442.board_1113;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/save")
    public String save(@RequestBody BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);
        return "Success";
    }
    @GetMapping("/")
    public List<BoardDTO> home() {
        List<BoardDTO> Boards;
        Boards = boardService.getBoard();
        return Boards;
    }
}
