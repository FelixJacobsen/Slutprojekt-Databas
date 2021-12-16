package org.example.def.student;

import org.example.def.course.Course;
import org.example.def.education.Education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentImpl implements StudentDao{
    EntityManagerFactory emf;
    EntityManager em;

    public StudentImpl(){
        this.emf = Persistence.createEntityManagerFactory("Slutprojekt");
        this.em = emf.createEntityManager();
    }


    @Override
    public void insert(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT c FROM Student c",Student.class).getResultList();
    }

    @Override
    public List<Student> getByName(String name) {
        return null;
    }

    @Override
    public List<Student> getByCourse(Course course) {
        return null;
    }

    @Override
    public List<Student> getByAge(int age) {
        return null;
    }

    @Override
    public List<Student> getByEducation(Education education) {
        return null;
    }
}
