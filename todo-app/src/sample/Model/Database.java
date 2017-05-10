package sample.Model;

import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * Created by watarumaeda on 2017/04/28.
 */
public class Database
{
    // Singleton
    private static final Database instance = new Database();
    public static Database sharedInstance() {
        return instance;
    }

    private ArrayList<Todo> allTodos = new ArrayList<Todo>();
    private ArrayList<User> allUsers = new ArrayList<User>();

    // Check if the user exists
    public boolean isUserExists(String userName, String password)
    {
        ArrayList<User> usres = getAllUsers();
        for (User user: usres)
        {
            String nm = user.getName();
            String psw = user.getPassword();
            if (userName.equals(nm) && password.equals(psw)) {
                return true;
            }
        }

        return false;
    }

    // Create account
    public boolean createUserAccount(String userName, String password)
    {
        if (allUsers.size() == 0) setAllUsers();
        if (isUserExists(userName, password)) return false;

        allUsers.add(new User(userName,  password));
        return true;
    }

    // Get user related todo list
    public ArrayList<Todo> getUserTodos(User user)
    {
        ArrayList<Todo> userTodo = new ArrayList<Todo>();
        ArrayList<Todo> allTodos = getAllTodos();
        for(Todo todo : allTodos)
        {
            String name = todo.getUser().getName();
            String pwd = todo.getUser().getPassword();
            if (name.equals(user.getName()) && pwd.equals(user.getPassword()))
            {
                userTodo.add(todo);
            }
        }
        return userTodo;
    }

    private ArrayList<User> getAllUsers()
    {
        if (allUsers.size() == 0) setAllUsers();
        return  allUsers;
    }

    private ArrayList<Todo> getAllTodos()
    {
        if (allTodos.size() == 0) setAllTodos();
        return  allTodos;
    }

    private void setAllUsers()
    {
        allUsers.add(new User("Ken",  "123"));
        allUsers.add(new User("Momo",  "123"));
        allUsers.add(new User("Maimai",  "123"));
        allUsers.add(new User("Wataru",  "123"));
    }

    public void addNewTodo(String txtftodo,User user){
        allTodos.add(new Todo(txtftodo, new User(user.getName(),user.getPassword())));
    }

    public void removeTodo(String txtftodo, User user)
    {
        for (int i = 0; i < allTodos.size(); i++)
        {
            Todo todo = allTodos.get(i);
            String title = todo.getTitle();
            String name = todo.getUser().getName();
            String pwd = todo.getUser().getPassword();

            if (title.equals(txtftodo) && name.equals(user.getName()) && pwd.equals(user.getPassword()))
            {
                allTodos.remove(i);
            }
        }
    }

    private void setAllTodos()
    {
        allTodos.add(new Todo("Ken's Task 1", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 2", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 3", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 4", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 5", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 6", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 7", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 8", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 9", new User("Ken","123")));
        allTodos.add(new Todo("Ken's Task 10", new User("Ken","123")));
        allTodos.add(new Todo("Momo's Task 1", new User("Momo", "123")));
        allTodos.add(new Todo("Momo's Task 2", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 3", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 4", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 5", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 6", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 7", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 8", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 9", new User("Momo","123")));
        allTodos.add(new Todo("Momo's Task 10", new User("Momo","123")));
        allTodos.add(new Todo("Maimai's Task 1", new User("Maimai", "123")));
        allTodos.add(new Todo("Maimai's Task 2", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 3", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 4", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 5", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 6", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 7", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 8", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 9", new User("Maimai","123")));
        allTodos.add(new Todo("Maimai's Task 10", new User("Maimai","123")));
        allTodos.add(new Todo("Wataru's Task 1", new User("Wataru", "123")));
        allTodos.add(new Todo("Wataru's Task 2", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 3", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 4", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 5", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 6", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 7", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 8", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 9", new User("Wataru","123")));
        allTodos.add(new Todo("Wataru's Task 10", new User("Wataru","123")));
    }
}


