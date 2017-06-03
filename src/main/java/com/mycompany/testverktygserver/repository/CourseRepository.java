package com.mycompany.testverktygserver.repository;

import com.mycompany.testverktygserver.models.Answer;
import java.util.List;
import com.mycompany.testverktygserver.models.CompletedTest;
import com.mycompany.testverktygserver.models.Course;
import com.mycompany.testverktygserver.models.Question;
import com.mycompany.testverktygserver.models.Student;
import com.mycompany.testverktygserver.models.Test;
import org.hibernate.Session;

public class CourseRepository {
    
    //Hämta kurs och prov
    public List<Course> getCourses(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Course> courses = session.createCriteria(Course.class).list();
        return courses;
    }
    
    //hämta test
    public List<Course> getTests(){
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        List<Course> courses = session.createCriteria(Course.class).list();
        for(Course cTest : courses) {
            cTest.getTests().size();
        }
        return courses;
    }
    
    public Course getCourses(int courseId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Course course = (Course) session.get(Course.class, courseId);
        return course;
    }

    public Test addTests(Course courseToAddTestIn, Test test) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        test.setCourse(courseToAddTestIn);
        session.save(test);
        session.getTransaction().commit();
        session.close();
        
        return test;
    }

    public Test getTest(int testId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Test test = (Test) session.get(Test.class, testId);
        return test;
    }

    public Question addQuestion(Test testToAddQuestionIn, Question question) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        question.setTest(testToAddQuestionIn);
        session.save(question);
        session.getTransaction().commit();
        session.close();
        
        return question;
    }

    public Question getQuestion(int questionId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Question question = (Question) session.get(Question.class, questionId);
        return question;
    }

    public void addAnswer(Question questionToAddAnswerIn, Answer answer) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        answer.setQuestion(questionToAddAnswerIn);
        session.save(answer);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteTest(int testId) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Test persistentInstance = (Test) session.load(Test.class, testId);
        session.delete(persistentInstance);
        session.getTransaction().commit();
        session.close();
    }
}
