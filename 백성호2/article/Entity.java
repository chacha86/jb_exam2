package 시험2.article;

import 시험2.Util.Util;

public class Entity {
    private int id;
    private String title;
    private String content;

    private String date;

    private int viewCount;
    private static int createCount = 1;


    Entity() {
        createCount++;
    }

    Entity(String title, String content) {
        this.id = createCount;
        this.title = title;
        this.content = content;
        this.viewCount = 0;
        this.date = Util.nowDateTime();
        createCount++;
    }

    Entity(int id, String title, String content, String date, int viewCount) {
        this.id = createCount;
        this.title = title;
        this.content = content;
        this.date = date;
        this.viewCount = viewCount;
        createCount++;
    }

    public int getId() {
        return id;

    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public int getViewCount() {
        return viewCount;
    }



    public void setId(int id) {
        this.id=id;

    }

    public void setTitle(String title) {
        this.title=title;
    }

    public void setContent(String content) {
       this.content=content;
    }

    public void setDate(String date ) {
        this.date =date;
    }

    public void setViewCount(int viewCount) {
        this.viewCount=viewCount;
    }

}
