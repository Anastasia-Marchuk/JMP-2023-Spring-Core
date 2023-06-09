package jmp.amarchuk.model;

import java.util.Date;

public class Event {

    private long id;
    private String title;
    private Date date;

    public Event(Long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
    this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
    this.title=title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
    this.date=date;
    }

    public String toString() {
        return "Event: " +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'';
    }
}
