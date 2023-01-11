package com.edu.dao.base;

import com.edu.dao.academic.TableNameDao;
import com.edu.dao.academic.impl.TableNameDaoImpl;
import com.edu.dao.assistant.*;
import com.edu.dao.assistant.impl.*;

public class DaoFactory {
    // 单例模式
    private static DaoFactory daoFactory;
    // 静态创建工厂
    static {
        daoFactory = new DaoFactory();
    }

    private DaoFactory(){}
    public  static DaoFactory getInstance(){
        return daoFactory;
    }

    // 工厂创建Dao对象
    public TableNameDao getTableNameDao(){return new TableNameDaoImpl();}

    public AssessmentDao getAssessmentDao(){return new AssessmentDaoImpl();}

    public CourseDao getCourseDao(){return new CourseDaoImpl();}

    public TeacherDao getTeacherDao(){return new TeacherDaoImpl();}

    public CourseTeacherDao getCourseTeacherDao(){return new CourseTeacherDaoImpl();}

    public StudentDao getStudentDao(){return new StudentDaoImpl();}


    // 下面可以加更多的Dao对象,如下
//    public ScoreDao getScoreDao(){return new ScoreDaoImpl(); }

}
