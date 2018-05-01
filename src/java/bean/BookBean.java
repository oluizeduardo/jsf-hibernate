package bean;

import dao.BookDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import entities.Book;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author Luiz Eduardo Costa
 */
@ManagedBean(name = "bookBean")
public class BookBean {
 
    private Book book = new Book();
    private List<Book> list;
    
    public BookBean(){
        //this.book = new Book();
        this.list = new ArrayList<>();
    }

    
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
    
    /**
     * Save a new book.
     */
    public void save(){        
        BookDAO bookDAO = new BookDAO();
        
        bookDAO.save(book);
        init();
    }
    
    /**
     * Clean all the fields.
     */
    public void clean(){
        this.book = new Book();
        System.out.println("Cleanning the fields...");
    }
    
    
    @PostConstruct
    private void init(){
        BookDAO bookDAO = new BookDAO();
        this.list = bookDAO.listAll();
        this.book = new Book();
    }
}
