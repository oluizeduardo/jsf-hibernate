package interfaces;

import entities.Book;
import java.util.List;

/**
 *
 * @author Luiz Eduardo Costa
 */
public interface CRUDMethods {
    
    public void save(entities.Book b);
    
    public List<Book> searchById(int id);       
    
    public List<Book> searchByTitle(String title);
    
    public List<Book> searchByAuthor(String author);
    
    public List<Book> searchByPublisher(String publisher);
    
    public List<Book> searchByGenre(String genre);
    
    public List<Book> listAll();
}
