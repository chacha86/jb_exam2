package assessment_2.article.boardcontroller;

import assessment_2.article.entity.Article;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardController {
    List<Article> articles = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int id = 1;

    public void DefaultPost() {
        Article article1 = new Article(id, "안녕하세요 반갑습니다. 자바 공부중이에요.", "첫번째 내용");
        article1.setRegistrationDates(formattedNow());
        articles.add(article1);
        id++;

        Article article2 = new Article(id, "자바 질문좀 할게요~", "MVC 패턴이 뭔가요?");
        article2.setRegistrationDates(formattedNow());
        articles.add(article2);
        id++;

        Article article3 = new Article(id, "정처기 따야되나요?", "세번째 내용");
        article3.setRegistrationDates(formattedNow());
        articles.add(article3);
        id++;
    }

    public void addPost() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = sc.nextLine();

        Article article = new Article(id, title, content);
        article.setRegistrationDates(formattedNow());
        articles.add(article);
        id++;

        System.out.println("게시물이 등록되었습니다.");
    }

    public void listPost() {
        if (articles.isEmpty()) {
            System.out.println("등록된 게시물이 없습니다.");
        } else {
            System.out.println("=================");
            for (Article article : articles) {
                System.out.println("번호: " + article.getIds());
                System.out.println("제목: " + article.getTitles());
                System.out.println("=================");
            }
        }
    }

    public String formattedNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter farmatter = DateTimeFormatter.ofPattern("yyyy.MM.DD HH:mm:ss");
        String formattedNow = now.format(farmatter);
        return formattedNow;
    }

    public void updatePost() {
        System.out.print("수정할 게시물 번호 : ");
        int index = 0;

        try {
            index = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return;
        }

        Article article = findArticleById(index);

        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
        } else {
            System.out.print("제목 : ");
            String newTitle = sc.nextLine();
            System.out.print("내용 : ");
            String newContent = sc.nextLine();

            article.setTitles(newTitle);
            article.setContents(newContent);

            System.out.println(index + "번 게시물이 수정되었습니다.");
        }
    }

    public Article findArticleById(int index) {
        for (Article article : articles) {
            if (article.getIds() == index) {
                return article;
            }
        }
        return null;
    }

    public void deletePost() {
        System.out.print("삭제할 게시물 번호 : ");
        int index = 0;

        try {
            index = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return;
        }

        Article article = findArticleById(index);

        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
        } else {
            articles.remove(article);
            System.out.println(index + "번 게시물이 삭제되었습니다.");
        }
    }

    public void detailPost() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int index = 0;

        try {
            index = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return;
        }

        Article article = findArticleById(index);

        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
        } else {
            System.out.println("===================");
            System.out.println("번호 : " + article.getIds());
            System.out.println("제목 : " + article.getTitles());
            System.out.println("내용 : " + article.getContents());
            System.out.println("등록날짜 : " + article.getRegistrationDates());
            article.setViews(article.getViews() + 1);
            System.out.println("조회수 : " + article.getViews());
            System.out.println("===================");
        }
    }

    public void searchPost() {
        System.out.print("검색할 키워드를 입력해주세요: ");
        String keyword = sc.nextLine();

        List<Article> searchResults = new ArrayList<>();

        for (Article article : articles) {
            if (article.getTitles().contains(keyword)) {
                searchResults.add(article);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("==================");
            for (Article article : searchResults) {
                System.out.println("번호: " + article.getIds());
                System.out.println("제목: " + article.getTitles());
                System.out.println("==================");
            }
        }


    }
}
