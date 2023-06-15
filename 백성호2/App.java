package 시험2;

import 시험2.control.ArticleControl;

import java.util.Scanner;

public class App {

    Scanner sc ;
    ArticleControl con;

    App(){
       sc = new Scanner(System.in);
       con= new ArticleControl();

    }
    public void Run(){



        while(true){
            System.out.print("명령어를 입력해주세요");
            switch (sc.nextLine()){
                case "add":
                    con.add();
                    break;
                case "list":
                    con.list();
                    break;
                case "update":
                    con.update();
                    break;
                case "delete":
                    con.delete();
                    break;
                case "detail":
                    con.detail();
                    break;
                case "search":
                    con.search();
                    break;
                case "exit":
                    con.exit();
                    return ;    //시스템종료
                default:
                    System.out.println("잘못된 명령어입니다.");
                    break;
            }

        }

    }
}
