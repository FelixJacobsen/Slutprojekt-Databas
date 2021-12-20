package org.example.def.course;

import org.example.def.student.Student;
import org.example.def.teacher.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseImpl implements CourseDao {
    EntityManagerFactory emf;
    EntityManager em;

    public CourseImpl() {
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
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course getById(int id) {
        return em.find(Course.class,id);
    }


    @Override
    public List<Course> getByName(String name) {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c WHERE fullName =:name ", Course.class);
        query.setParameter("name", name);
        return query.getResultList();
    }


    @Override
    public List<Course> getByTeacher(Teacher teacher) {
        return teacher.getCourseList();
    }


    @Override
    public List<Course> orderByLength() {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c ORDER BY startDate DESC", Course.class);
        return query.getResultList();
    }
}
