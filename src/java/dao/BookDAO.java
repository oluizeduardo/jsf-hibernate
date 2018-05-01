package dao;

import entities.Book;
import interfaces.CRUDMethods;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;

/**
 *
 * @author Luiz Eduardo Costa
 */
public class BookDAO implements CRUDMethods{
    
    
    public BookDAO(){}

    /**
     * Save anew book.
     * 
     * @param newBook 
     */
    @Override
    public void save(Book newBook) {
        Session session = this.openSession();
        session.beginTransaction();
        
        try{
            session.persist(newBook);
        }catch(ConstraintViolationException ex){
            System.err.println(ex.getMessage());
        
        }
        session.getTransaction().commit();
        session.close();
    }

    
    /**
     * Searches all the books into database.
     * @return A List of {@link  Book}'s object.
     */
    @Override
    public List<Book> listAll() {
        
        Session session = this.openSession();
        List<Book> list = session.getNamedQuery("Book.findAll").list();
        session.close();
        
        return list;
    }
    
    
    /**
     * It returns a new Hibernate session.
     * 
     * @return A hibernate session.
     */
    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
    
    
}
