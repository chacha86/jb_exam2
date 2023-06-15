package assessment_2;

import assessment_2.article.boardcontroller.BoardController;
import assessment_2.systemcontroller.SystemController;

import java.util.Scanner;

public class App {
    Scanner sc;
    SystemController systemController;
    BoardController boardController;

    App() {
        sc = new Scanner(System.in);
        systemController = new SystemController();
        boardController = new BoardController();
    }

    public void run() {
        boardController.DefaultPost();
        while (true) {
            System.out.print("명령어 : ");
            String cmd = sc.nextLine();

            if (cmd.equals("exit")) {
                systemController.exitPost();
                return;
            } else if (cmd.equals("add")) {
                boardController.addPost();
            } else if (cmd.equals("list")) {
                boardController.listPost();
            } else if (cmd.equals("update")) {
                boardController.updatePost();
            } else if (cmd.equals("delete")) {
                boardController.deletePost();
            } else if (cmd.equals("detail")) {
                boardController.detailPost();
            } else if (cmd.equals("search")) {
                boardController.searchPost();
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
            }
        }
    }


}
