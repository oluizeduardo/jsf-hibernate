package bean;

import dao.BookDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import entities.Book;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Eduardo Costa
 */
@ManagedBean(name = "bookBean")
public class BookBean {
 
    private Book book = new Book();
    private List<Book> list;
    private String searchBy="all";
    private String valueUsedInSearching;
    
    
    public BookBean(){ }

    
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
    
    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }
    
    public String getValueUsedInSearching() {
        return valueUsedInSearching;
    }

    public void setValueUsedInSearching(String valueUsedInSearching) {
        this.valueUsedInSearching = valueUsedInSearching;
    }
    
    /**
     * Save a new book.
     */
    public void save(){        
        BookDAO bookDAO = new BookDAO();
        
        bookDAO.save(book);
        init();
    }
    
    
    public void search(){
        
//        JOptionPane.showMessageDialog(null,"Search By: "+searchBy+" Value used: "+valueUsedInSearching);
        
        BookDAO bookDAO = new BookDAO();
        switch(searchBy){
//            case "id":
//                this.list = bookDAO.searchById(book.getId());
//            break;
            case "title":
                this.list = bookDAO.searchByTitle(valueUsedInSearching);
            break;
            case "author":
                this.list = bookDAO.searchByAuthor(valueUsedInSearching);
            break;
            case "publisher":
                this.list = bookDAO.searchByPublisher(valueUsedInSearching);
            break;
            case "genre":
                this.list = bookDAO.searchByGenre(valueUsedInSearching);
            break;
            case "all":
                this.list = bookDAO.listAll();
            break;
        }
    }
    
    
    @PostConstruct
    private void init(){
        BookDAO bookDAO = new BookDAO();
        this.list = bookDAO.listAll();
        this.book = new Book();
    }
}
