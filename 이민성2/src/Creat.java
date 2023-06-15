public class Creat {
    String title;
    String content;
    MakeDate date;

    int view;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MakeDate getDate() {
        return date;
    }

    public void setDate(MakeDate date) {
        this.date = date;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Creat(String title, String content, MakeDate date, int view) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.view = view;
    }

}
