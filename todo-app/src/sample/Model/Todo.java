package sample.Model;

/**
 * Created by watarumaeda on 2017/04/28.
 */
public class Todo
{
    private String title;
    private User user;

    public Todo(String title, User user) {
        this.title = title;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
