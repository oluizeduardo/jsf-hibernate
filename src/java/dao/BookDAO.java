package dao;

import entities.Book;
import interfaces.CRUDMethods;
import java.util.List;
import org.hibernate.Query;
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
     * It returns a new Hibernate session.
     * 
     * @return A hibernate session.
     */
    private Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }
    
    /**
     * Save a new book.
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

    
    @Override
    public List<Book> listAll() {        
        Session session = this.openSession();
        List<Book> list = session.getNamedQuery("Book.findAll").list();
        session.close();        
        return list;
    }
    

    @Override
    public List<Book> searchById(int id) {
        Session session = this.openSession();
        Query query = session.getNamedQuery("Book.findById");
        query.setParameter("id", id);
        List<Book> list = query.list();
        session.close();
        return list;
    }


    @Override
    public List<Book> searchByTitle(String title) {
        Session session = this.openSession();
        Query query = session.getNamedQuery("Book.findByTitle");
        query.setParameter("title", title);
        List<Book> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        Session session = this.openSession();
        Query query = session.getNamedQuery("Book.findByAuthor");
        query.setParameter("author", author);
        List<Book> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Book> searchByPublisher(String publisher) {
        Session session = this.openSession();
        Query query = session.getNamedQuery("Book.findByPublisher");
        query.setParameter("publisher", publisher);
        List<Book> list = query.list();
        session.close();
        return list;
    }

    @Override
    public List<Book> searchByGenre(String genre) {
        Session session = this.openSession();
        Query query = session.getNamedQuery("Book.findByGenre");
        query.setParameter("genre", genre);
        List<Book> list = query.list();
        session.close();
        return list;
    }
    
    
}
