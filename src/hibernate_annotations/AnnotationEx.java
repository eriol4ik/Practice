package hibernate_annotations;

import hibernate_annotations.entity.Author;
import hibernate_annotations.entity.Book;
import hibernate_annotations.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by eriol4ik on 04/02/2017.
 */
public class AnnotationEx {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Book book = new Book("SOME_BOOK");
        Author author = new Author("Author", "Author", book);
        book.setAuthor(author);

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();

        session.beginTransaction();
        Author fromBase = (Author) session.get(Author.class, 1L);

        System.out.println(fromBase.getName());
        System.out.println(fromBase.getBook().getTitle() + " " + fromBase.getBook().getId());

        Book fromBaseBook = (Book) session.get(Book.class, 1L);

        System.out.println();

        session.close();

        HibernateUtil.getSessionFactory().close();
    }
}
