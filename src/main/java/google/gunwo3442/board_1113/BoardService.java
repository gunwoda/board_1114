package google.gunwo3442.board_1113;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void saveBoard(BoardDTO boardDTO) {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date published_date = sdf.parse(boardDTO.getDate());

            Board board = Board.builder()
                    .user_id(boardDTO.getUser_id())
                    .board_id(boardDTO.getBoard_id())
                    .date(published_date)
                    .title(boardDTO.getTitle())
                    .content(boardDTO.getContent())
                    .build();

            boardRepository.save(board);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public BoardDTO getBoardDTO(int board_id) {
        Board board = boardRepository.findById(board_id).orElse(null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str_date = sdf.format(board.getDate());
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_id(board.getBoard_id());
        boardDTO.setUser_id(board.getUser_id());
        boardDTO.setTitle(board.getTitle());
        boardDTO.setContent(board.getContent());
        boardDTO.setDate(str_date);
        return boardDTO;
    }
    public ArrayList<BoardDTO> getBoard() {
        try{
            ArrayList<BoardDTO> boardDTOs = new ArrayList<>();
            List<Board> boards = boardRepository.findAll();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Board board : boards) {
                int id = board.getBoard_id();
                boardDTOs.add(getBoardDTO(id));
            }
            return boardDTOs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBoard(int board_id) {
        try{
            boardRepository.deleteById(board_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
