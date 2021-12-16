package org.example.def.course;

import org.example.def.student.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseImpl implements CourseDao {
    EntityManagerFactory emf;
    EntityManager em;

    public CourseImpl(){
        this.emf = Persistence.createEntityManagerFactory("Slutprojekt");
        this.em = emf.createEntityManager();
    }



    @Override
    public void insert(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void update(Course course) {
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Course course) {
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
    }

    @Override
    public List<Course> getAll() {
        return em.createQuery("SELECT c FROM Course c",Course.class).getResultList();
    }





    @Override
    public List<Course> getByName(String name) {
        return null;
    }

    @Override
    public List<Course> getById(long id) {
        return null;
    }

    @Override
    public List<Course> getByStudent(Student student) {
        return null;
    }

    @Override
    public List<Course> getByLength(int length) {
        return null;
    }
}
