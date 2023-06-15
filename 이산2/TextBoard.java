import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TextBoard {
    private ArrayList<Article> articleList = new ArrayList<>();
    public void start(){
        Scanner scanner = new Scanner(System.in);

        boolean check = true;
        // tester 삭제시 1로 변경
        int id = 4;

        Tester tester = new Tester(articleList);
        tester.run();

        while (check){

            System.out.printf("명령어 : ");
            String cmd = scanner.nextLine();

            if(cmd.equals("add")){
                PostAdd postadd = new PostAdd(id, articleList);
                postadd.run();
            }else if(cmd.equals("list")){
                PostList postList = new PostList(articleList);
                postList.run();
            }else if(cmd.equals("update")){
                PostUpdate postUpdate = new PostUpdate(articleList);
                postUpdate.run();
            }else if(cmd.equals("delete")){
                PostDelete postDelete = new PostDelete(articleList);
                postDelete.run();
            }else if(cmd.equals("detail")){
                PostDetail postDetail = new PostDetail(articleList);
                postDetail.run();
            }else if(cmd.equals("search")){
                PostSearch postSearch = new PostSearch(articleList);
                postSearch.run();
            }else if(cmd.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                check = false;
            }else{
                System.out.println("잘못된 입력입니다.");
            }
        }

    }
}
class Article{
    private String title;
    private String body;
    private int id;
    private int hit;
    private String postUpDate;
    Article(){

    }

    Article(int id, String title, String body, String postUpDate){
        this.id = id;
        this.title = title;
        this.body = body;
        this.postUpDate = postUpDate;
    }
    public void setTitle(String title){this.title = title;}
    public void setBody(String body){this.body = body;}
    public void setId(int id){this.id = id;}
    public void setHit(int hit){this.hit = hit;}
    public void setPostUpDate(String postUpDate){this.postUpDate = postUpDate;}
    public String getTitle(){return title;}
    public String getBody(){return  body;}
    public String getPostUpDate(){return  postUpDate;}
    public int getId(){return id;}
    public int getHit(){return hit;}

}
class Tester{
    ArrayList<Article> articleList;
    Util util = new Util();
    Tester(ArrayList<Article> articleList){
        this.articleList = articleList;
    }
    public void run(){
        Article article1 = new Article(1,"안녕하세요 반갑습니다. 자바 공부중이에요.","",util.currentDateTime());

        Article article2 = new Article(2,"자바 질문좀 할게요~","",util.currentDateTime());

        Article article3 = new Article(3,"정처기 따야되나요?","",util.currentDateTime());


        articleList.add(article1);
        articleList.add(article2);
        articleList.add(article3);
    }
}
class PostAdd{
    ArrayList<Article> articleList;
    Scanner scanner;
    Util util = new Util();
    int id;
    PostAdd(int id, ArrayList<Article> articleList){
        this.articleList = articleList;
        this.scanner = new Scanner(System.in);
        this.id = id;
    }

    public void run(){
        Article article = new Article();

        System.out.printf("제목을 입력해주세요 : ");
        String title = scanner.nextLine();
        System.out.printf("내용을 입력해주세요 : ");
        String body = scanner.nextLine();

        article.setId(id);
        article.setTitle(title);
        article.setBody(body);
        article.setPostUpDate(util.currentDateTime());
        article.setHit(0);
        articleList.add(article);

        System.out.println("게시물이 등록되었습니다.");
    }
}
class PostList{
    ArrayList<Article> articleList;
    PostList(ArrayList<Article> articleList){
        this.articleList = articleList;
    }

    public void run(){
        System.out.println("==============================");
        for(Article data : articleList){
            System.out.println("번호 : " + data.getId());
            System.out.println("제목 : " + data.getTitle());
            System.out.println("==============================");
        }
    }
}
class PostUpdate{
    ArrayList<Article> articleList;
    Scanner scanner;
    public PostUpdate(ArrayList<Article> articleList) {
        this.articleList = articleList;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        boolean found = false;
        while (!found){
            System.out.printf("수정할 게시물 번호 : ");

            String inputData = scanner.nextLine();
            int id = 0;
            try{
                id = Integer.parseInt(inputData);
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            for(Article data : articleList){
                if(data.getId() == id){
                    System.out.printf("제목 : ");
                    String newTitle = scanner.nextLine();
                    System.out.printf("내용 : ");
                    String newBody = scanner.nextLine();

                    data.setTitle(newTitle);
                    data.setBody(newBody);

                    System.out.println(id + "번 게시물이 수정되었습니다.");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("없는 게시물입니다.");
            }
        }
    }
}

class PostDelete{
    ArrayList<Article> articleList;
    Scanner scanner;
    public PostDelete(ArrayList<Article> articleList) {
        this.articleList = articleList;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        boolean found = false;
        while (!found){
            Iterator<Article> articleIterator = articleList.iterator();
            System.out.printf("삭제할 게시물 번호 : ");

            String inputData = scanner.nextLine();
            int id = 0;
            try{
                id = Integer.parseInt(inputData);
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            found = false;
            while(articleIterator.hasNext()){
                Article data = articleIterator.next();

                if(data.getId() == id){
                    articleIterator.remove();
                    System.out.println("게시물이 삭제되었습니다.");
                    found = true;
                    break;
                }
        }
            if(!found){
                System.out.println("없는 게시물입니다.");
            }
        }
    }
}
class PostDetail{
    Scanner scanner;
    ArrayList<Article> articleList;
    public PostDetail(ArrayList<Article> articleList) {
        this.articleList = articleList;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
        boolean found = false;
        while(!found){
            System.out.printf("상세보기할 게시물 번호를 입력해주세요 : ");

            String inputData = scanner.nextLine();
            int id = 0;
            try{
                id = Integer.parseInt(inputData);
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            for(Article data : articleList){
                if(data.getId() == id){
                    data.setHit(data.getHit() + 1);
                    System.out.println("==============================");
                    System.out.println("번호 : " + data.getId());
                    System.out.println("제목 : " + data.getTitle());
                    System.out.println("내용 : " + data.getBody());
                    System.out.println("등록날짜 : " + data.getPostUpDate());
                    System.out.println("조회수 : " + data.getHit());
                    System.out.println("==============================");

                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("없는 게시물입니다.");
            }
        }
    }
}
class PostSearch{
    Scanner scanner;
    ArrayList<Article> articleList;
    public PostSearch(ArrayList<Article> articleList) {
        this.articleList = articleList;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.printf("검색 키워드를 입력해주세요 : ");
        String keyword = scanner.nextLine();

        boolean found = false;
        for(Article data : articleList){
            if(data.getTitle().contains(keyword)){
                System.out.println("==============================");
                System.out.println("번호 : " + data.getId());
                System.out.println("제목 : " + data.getTitle());
                System.out.println("==============================");
                found = true;
            }
        }
        if(!found){
            System.out.println("==============================");
            System.out.println("검색결과가 없습니다.");
            System.out.println("==============================");
        }
    }
}
class Util {
    String formmattedTime;

    public String currentDateTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return formmattedTime = currentTime.format(formatter);
    }
}