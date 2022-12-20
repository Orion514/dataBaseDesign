package com.edu.dao.base;

import com.edu.dao.ScoreDao;
import com.edu.dao.StudentDao;
import com.edu.dao.impl.ScoreDaoImpl;
import com.edu.dao.impl.StudentDaoImpl;
import com.edu.pojo.Score;

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
    public StudentDao getStudentDao(){
        return new StudentDaoImpl();
    }
    public ScoreDao getScoreDao(){return new ScoreDaoImpl(); }

}
