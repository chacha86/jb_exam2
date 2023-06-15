
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;




public class Start {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime nowTime = LocalDateTime.now();
        Scanner cmd = new Scanner(System.in);
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();
        ArrayList<Integer> views = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        String formattedTime = nowTime.format(formatter);

        titles.add("안녕하세요 반갑습니다. 자바 공부중이에요");
        titles.add("자바 질문좀 할게요~");
        titles.add("정처기 따야되나요?");
        contents.add("반갑습니다");
        contents.add("자바");
        contents.add("hello");
        views.add(0);
        views.add(0);
        views.add(0);
        dates.add(formattedTime);
        dates.add(formattedTime);
        dates.add(formattedTime);



//        ArrayList<Creat> post = new ArrayList<>();
        while(true){
            System.out.println("명령어를 입력해주세요");
            String maincmd = cmd.nextLine();

            if(maincmd.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }else if (maincmd.equals("add")){
                System.out.println("게시물 제목을 입력해주세요.");
                String title = cmd.nextLine();
                System.out.println("내용을 입력해주세요.");
                String content = cmd.nextLine();
                int view = 0;

              titles.add(title);
              contents.add(content);
              views.add(view);
              dates.add(formattedTime);

            }else if (maincmd.equals("list")){
                System.out.printf("==========\n");
                for(int i = 0; i < titles.size(); i++) {
                    System.out.printf("번호: %d\n", i + 1);
                    System.out.printf("제목: %s\n", titles.get(i));
                    System.out.printf("==========\n");
                }

            }else if(maincmd.equals("delete")){
                    System.out.println("삭제할 게시판의 번호를 입력해주세요");
                    int deleteNum = cmd.nextInt();
                    int deleteNum1 = deleteNum - 1;
                    if(deleteNum > 0 || deleteNum <= titles.size()){
                    contents.remove(deleteNum1);
                    titles.remove(deleteNum1);
                    views.add(deleteNum1);
                        System.out.println("삭제했습니다.");
                    }else{
                        System.out.println("없는 번호입니다.");
                    }



            }else if (maincmd.equals("update")){
                Scanner cmdupdate = new Scanner(System.in);
                Scanner cmdupdate1 = new Scanner(System.in);
                System.out.println("수정할 게시판의 번호를 입력해주세요.");
                int updateNum = cmdupdate.nextInt();

                int updateNumm = updateNum - 1;

                if(updateNum > titles.size() || updateNum < 0){
                    System.out.println("없는 게시물 번호입니다.");
                } else {
                    System.out.printf("새로 수정할 게시판의 제목을 입력하세요\n");
                    String retitls = cmdupdate1.nextLine();

                    System.out.printf("새로 수정할 게시판의 내용을 입력하세요\n");
                    String recontents = cmdupdate1.nextLine();

                    System.out.printf("%d번 게시물이 수정되었습니다.\n", updateNum);

                    titles.set(updateNumm , retitls);
                    contents.set(updateNumm , recontents);}

            }else if (maincmd.equals("search")){
                Scanner cmd3 = new Scanner(System.in);
                System.out.println("제목에 찾을 단어를 입력해주세요.");
                String searchtext = cmd3.nextLine();
                for(int i = 0; i < titles.size() ; i++){
                    if(titles.contains(searchtext)){
                        System.out.printf("==========\n");
                        System.out.printf("번호: %d\n", i + 1);
                        System.out.printf("제목: %s\n", titles.get(i));
                        System.out.printf("==========\n");
                        break;
                    }else {
                        System.out.println("해당 단어가 포함된 게시글은 없습니다.");
                    }
                }
            }else if(maincmd.equals("detail")){
                Scanner cmd4 = new Scanner(System.in);
                System.out.println("상세보기할 게시물의 번호를 작성해주세요");
                int detail = cmd4.nextInt();
                int index = detail - 1;
                views.set(index , views.get(index) + 1);
                System.out.println("===========");
                System.out.printf("번호: %d\n", detail);
                System.out.printf("제목: %s\n", titles.get(index));
                System.out.printf("내용: %s\n", contents.get(index));
                System.out.printf("등록날짜 : %s\n", dates.get(index));
                System.out.printf("조회수 : %s\n", views.get(index));
                System.out.printf("==========\n");

            }
        }





}
}
