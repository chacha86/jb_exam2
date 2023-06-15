package 시험2.view;

import 시험2.article.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArticleView {
    Scanner sc;
    HashMap<String, Object> param;

    public ArticleView() {
        sc = new Scanner(System.in);
        param = new HashMap<>();
    }

    public HashMap<String, Object> viewAdd() {
        String title, content;
        System.out.println("저장을 시작합니다.");
        System.out.println("제목을입력하세요");
        title = sc.nextLine();
        System.out.println("내용을 입력하세요");
        content = sc.nextLine();
        param.put("title", title);
        param.put("content", content);

        return param;
    }

    public HashMap<String, Object> viewUpdate() {
        String title, content;
        System.out.println("수정을 시작합니다.");
        System.out.println("제목을입력하세요");
        title = sc.nextLine();
        System.out.println("내용을 입력하세요");
        content = sc.nextLine();
        param.put("title", title);
        param.put("content", content);
        return param;

    }

    public int viewGet_Id(String str) {
        while (true) {
            int id = -1;
            String check = "[0-9]+", id_check;
            System.out.println(str);
            id_check = sc.nextLine();

            if (id_check.matches(check)) {//숫자말고 다른거 입력하면 에러
                id = Integer.parseInt(id_check);
                return id;
            }

            if (id == -1) {
                System.out.println("잘못된값을 입력하셨습니다.");
            }

        }

    }
    public String viewGet_Title(String str){
        String title;
        System.out.println(str);
        title= sc.nextLine();
        return title;
    }

    public void viewList(ArrayList<Entity> articles) {
        System.out.println("저장된 데이터를 출력합니다.");
        for (Entity article : articles) {
            System.out.println("==================");
            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("==================");
        }
    }
    public void viewCustomList(Entity article){
            System.out.println("==================");
            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("==================");

    }

    public void viewDetail(Entity article) {
        System.out.println("저장된 데이터를 출력합니다.");

        System.out.println("==================");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getContent());
        System.out.println("등록날짜 : " + article.getDate());
        System.out.println("조회수 : " + article.getViewCount());
        System.out.println("==================");

    }
    public void viewExit(){
        System.out.println("프로그램을 종료합니다.");
    }

    public void viewCustom(String str){System.out.println(str);}
    public HashMap<String, Object> base() {
        return param;
    }


}
