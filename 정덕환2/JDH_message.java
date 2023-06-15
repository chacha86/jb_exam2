package JDH_message;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;

public class JDH_message {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> title = new ArrayList<>();
        ArrayList<String> content = new ArrayList<>();
        ArrayList<Integer> view = new ArrayList<>();
        ArrayList<Integer> boardnum = new ArrayList<>();
        ArrayList<Date> currentDate = new ArrayList<>();

        Date currentdate = new Date();

        int view_count = 1;
        int board_count = 1;

        // 테스트 데이터1
        title.add("안녕하세요 반갑습니다. 자바 공부중이에요.");
        content.add("");
        view.add(1);
        boardnum.add(board_count);
        currentDate.add(currentdate);
        board_count += 1;
        // 테스트 데이터2
        title.add("자바 질문좀 할게요~");
        content.add("");
        view.add(1);
        boardnum.add(board_count);
        currentDate.add(currentdate);
        board_count += 1;
        // 테스트 데이터3
        title.add("정처기 따야되나요?");
        content.add("");
        view.add(1);
        boardnum.add(board_count);
        currentDate.add(currentdate);
        board_count += 1;

        while (true) {
            System.out.print("명령어: ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("제목: ");
                String titles = scan.nextLine();
                title.add(titles);
                System.out.print("내용: ");
                String contentes = scan.nextLine();
                content.add(contentes);
                System.out.println("게시물이 등록되었습니다.");
                boardnum.add(board_count);
                board_count += 1;
                currentDate.add(currentdate);
                view.add(view_count);
            } else if (command.equals("list")) {
                for (int num = 0; num < boardnum.size(); num++) {
                    System.out.println("========================");
                    System.out.println(boardnum.get(num) + "번 게시판");
                    System.out.println("제목: " + title.get(num));
                    System.out.println("========================");
                }
            } else if (command.equals("update")) {
                boolean non = true;
                while (non) {
                    try {
                        System.out.print("수정할 게시물 번호: ");
                        int board_number = scan.nextInt();
                        scan.nextLine();
                        int index = boardnum.indexOf(board_number);
                        if (index != -1) {
                            System.out.print("새로운 제목: ");
                            String newtitles = scan.nextLine();
                            title.set(index, newtitles);
                            System.out.print("새로운 내용: ");
                            String newcontent = scan.nextLine();
                            content.set(index, newcontent);
                            System.out.println(board_number + "번 게시물이 수정되었습니다.");
                            non = false;
                        } else {
                            System.out.println("없는 게시물 번호입니다.");
                        }
                    } catch (InputMismatchException e1) {
                        System.out.println("숫자를 입력해주세요.");
                        scan.nextLine();
                    }
                }
            } else if (command.equals("delete")) {
                boolean non = true;
                while (non) {
                    try {
                        System.out.print("삭제할 게시물 번호: ");
                        int board_number = scan.nextInt();
                        scan.nextLine();
                        int index = boardnum.indexOf(board_number);
                        if (index != -1) {
                            title.remove(index);
                            content.remove(index);
                            view.remove(index);
                            boardnum.remove(index);
                            currentDate.remove(index);
                            System.out.println(board_number + "번 게시물이 삭제되었습니다.");
                            non = false;
                        } else {
                            System.out.println("없는 게시물 번호입니다.");
                        }
                    } catch (InputMismatchException e1) {
                        System.out.println("숫자를 입력해주세요.");
                        scan.nextLine();
                    }
                }
            } else if (command.equals("detail")) {
                boolean non = true;
                while (non) {
                    try {
                        System.out.print("상세보기할 게시물 번호를 입력해주세요: ");
                        int board_number = scan.nextInt();
                        scan.nextLine();
                        int index = boardnum.indexOf(board_number);
                        if (index != -1) {
                            System.out.println("========================");
                            System.out.println(boardnum.get(index) + "번 게시판");
                            System.out.println("제목: " + title.get(index));
                            System.out.println("내용: " + content.get(index));
                            System.out.println("등록날짜: " + currentDate.get(index));
                            System.out.println("조회수: " + view.get(index));
                            System.out.println("========================");
                            view.set(index, view.get(index) + 1);
                            non = false;
                        } else {
                            System.out.println("없는 게시물 번호입니다.");
                        }
                    } catch (InputMismatchException e1) {
                        System.out.println("숫자를 입력해주세요.");
                        scan.nextLine();
                    }
                }
            } else if (command.equals("search")) {
                System.out.print("제목을 검색해주세요: ");
                String searchTitle = scan.nextLine();
                boolean found = false;
                for (int i = 0; i < title.size(); i++) {
                    if (title.get(i).contains(searchTitle)) {
                        System.out.println("========================");
                        System.out.println(boardnum.get(i) + "번 게시판");
                        System.out.println("제목: " + title.get(i));
                        System.out.println("========================");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("일치하는 제목이 없습니다.");
                }
            }
        }
    }
}


