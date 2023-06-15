package 시험2.article;

import java.util.ArrayList;

public class ArticleRepogitory {
    ArrayList<Entity> articles;


    public ArticleRepogitory() {
        articles = new ArrayList<>();
        articles.add(new Entity("안녕하세요 반갑습니다. 자바 공부중이에요.","내용"));
        articles.add(new Entity(" 자바 질문좀 할게요~","내용"));
        articles.add(new Entity("정처기 따야되나요?","내용"));
    }

    public void add(String title, String content) {
        articles.add(new Entity(title, content));
    }
    public void update(int id,String title,String content){
        articles.get(id).setTitle(title);
        articles.get(id).setContent(content);

    }
    public void delete(int idx){
        articles.remove(idx);
    }
    public Entity detail(int idx){
        articles.get(idx).setViewCount(articles.get(idx).getViewCount()+1);
        return getAticle(idx);
    }
    public ArrayList<Integer> checkTitle(String title){
        ArrayList<Integer> idxs= new ArrayList<>();
        for(int i =0; i<articles.size();i++)
            if (articles.get(i).getTitle().contains(title)){
              idxs.add(i);
            }
        return idxs;

    }

    public int checkId(int id){
        for(int i =0; i<articles.size();i++){
            if(articles.get(i).getId()==id)
                return i;
        }
        System.out.println("존재하지않는번호입니다.");
        return -1;
    }


    public ArrayList<Entity> getAticles() {
        return articles;
    }
    public Entity getAticle(int idx){
        return articles.get(idx);
    }


}
