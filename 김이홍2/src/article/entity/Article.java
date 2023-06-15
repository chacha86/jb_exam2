package assessment_2.article.entity;

public class Article {
    private String titles;
    private String contents;
    private String registrationDates;
    private int views;
    private int ids;

    public Article(int ids, String titles, String contents) {
        this.ids = ids;
        this.titles = titles;
        this.contents = contents;
        this.registrationDates = null;
        this.views = 0;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getRegistrationDates() {
        return registrationDates;
    }

    public void setRegistrationDates(String registrationDates) {
        this.registrationDates = registrationDates;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public Article() {
    }

}
