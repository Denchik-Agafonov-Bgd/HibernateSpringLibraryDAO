package ru.agafonov.spring.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.agafonov.spring.library.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person){
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson){
        Session session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);

        person.setFio(updatePerson.getFio());
        person.setBirthday(updatePerson.getBirthday());
        person.setEmail(updatePerson.getEmail());
    }

    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Person.class, id));
    }


    /*public List<Book> getPersonBook(int id) {

    }

    public Optional<Person> getPersonByFio(String name) {

    }*/
}
