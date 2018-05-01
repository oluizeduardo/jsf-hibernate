package interfaces;

import entities.Book;
import java.util.List;

/**
 *
 * @author Luiz Eduardo Costa
 */
public interface CRUDMethods {
    
    public void save(entities.Book b);
    
    public List<Book> listAll();
}
