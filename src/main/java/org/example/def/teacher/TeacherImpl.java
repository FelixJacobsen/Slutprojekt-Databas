package org.example.def.teacher;

import org.example.def.course.Course;

import javax.persistence.*;
import java.util.List;

public class TeacherImpl implements TeacherDao {
    EntityManagerFactory emf;
    EntityManager em;

    public TeacherImpl() {
        this.emf = Persistence.createEntityManagerFactory("Slutprojekt");
        this.em = emf.createEntityManager();
    }


    @Override
    public void insert(Teacher teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Teacher teacher) {
        em.getTransaction().begin();
        teacher.getCourseList().forEach(course -> course.getTeacherList().remove(teacher));
        em.remove(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void update(Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    @Override
    public List<Teacher> getAll() {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher getById(int id) {
        return em.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> getByName(String name) {
        TypedQuery<Teacher> quary = em.createQuery("SELECT t FROM Teacher t WHERE fullName LIKE :name ", Teacher.class);
        quary.setParameter("name", name);
        return quary.getResultList();
    }

    @Override
    public List<Teacher> getByCourse(Course course) {
        return course.getTeacherList();
    }

    @Override
    public List<Teacher> orderByAge() {
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t ORDER BY age DESC ",Teacher.class);
        return query.getResultList();
    }
}
