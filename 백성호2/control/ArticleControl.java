package 시험2.control;

import 시험2.article.ArticleRepogitory;
import 시험2.view.ArticleView;

import java.util.ArrayList;
import java.util.HashMap;

public class ArticleControl {
    ArticleRepogitory articleRepogitory;
    ArticleView articleView;
    HashMap<String,Object> param;

    public ArticleControl(){
        articleRepogitory= new ArticleRepogitory();
        articleView=new ArticleView();
        param=new HashMap<>();
    }



    public void add(){
        String title, content;
        param= articleView.viewAdd();
        title=(String)param.get("title");
        content=(String)param.get("content");
        articleRepogitory.add(title,content);
    }

    public void list(){
        articleView.viewList(articleRepogitory.getAticles());
    }
    public void update(){
        int idx;
        String title,content;
        idx = articleRepogitory.checkId(
                articleView.viewGet_Id("수정할 게시물 번호 입력해주세요"));
        if(idx>-1){
            param = articleView.viewUpdate();
            title= (String)param.get("title");
            content= (String)param.get("content");
            articleRepogitory.update(idx,title, content);
        }
    }
    public void delete(){
        int idx;
        idx = articleRepogitory.checkId
                (articleView.viewGet_Id("삭제할 게시물 번호 입력해주세요"));
        if(idx>-1){
            articleRepogitory.delete(idx);
        }
    }
    public void detail(){
        int idx;
        idx = articleRepogitory.checkId
                (articleView.viewGet_Id("상세보기 할 게시물 번호를 입력해주세요"));
        articleView.viewDetail(articleRepogitory.detail(idx));
    }
    public void search(){
        ArrayList<Integer> idxs;//첫번째로 뷰에서 제목받기 그후 제목검사 반환
        idxs= articleRepogitory.checkTitle(
                articleView.viewGet_Title("검색할 제목을 입력해주세요"));
        if(idxs.size()>0 ){
            for(int idx :idxs)
                articleView.viewCustomList(articleRepogitory.detail(idx));
        }else articleView.viewCustom("검색결과가 없습니다.");
    }
    public void exit(){
        articleView.viewExit();
    }
}
