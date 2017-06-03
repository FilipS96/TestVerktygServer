package com.mycompany.testverktygserver.services;

import com.mycompany.testverktygserver.models.Answer;
import com.mycompany.testverktygserver.models.CompletedTest;
import com.mycompany.testverktygserver.models.Course;
import com.mycompany.testverktygserver.models.Question;
import com.mycompany.testverktygserver.models.Test;
import com.mycompany.testverktygserver.repository.CourseRepository;
import java.util.List;

public class CourseService {
        
    CourseRepository courseDB;
    
    public CourseService(){
        courseDB = new CourseRepository();
    }
    //Hämta lista av Kurser
    public List<Course> getCourses(){
        return courseDB.getCourses();
    }
    //Hämta Test
    public List<Course> getTests(){
        return courseDB.getTests();
    }

    public void addTests(int courseId, Test test) {
        Course courseToAddTestIn = courseDB.getCourses(courseId);
        Test returnedtest = courseDB.addTests(courseToAddTestIn, test);
        for (int i = 0; i < test.getQuestions().size(); i++) {
            Question returnedquestion = addQuestion(returnedtest.getId(), test.getQuestions().get(i));
            for (int j = 0; j < test.getQuestions().get(i).getAnswers().size(); j++) {
                addAnswer(returnedquestion.getId(), test.getQuestions().get(i).getAnswers().get(j));
            }
        }
    }

    public Question addQuestion(int testId, Question question) {
        Test testToAddQuestionIn = courseDB.getTest(testId);
        return courseDB.addQuestion(testToAddQuestionIn, question);
    }

    public void addAnswer(int questionId, Answer answer) {
        Question questionToAddAnswerIn = courseDB.getQuestion(questionId);
        courseDB.addAnswer(questionToAddAnswerIn, answer);
    }

    public void deleteTest(int testId) {
        courseDB.deleteTest(testId);
    }
    
}
