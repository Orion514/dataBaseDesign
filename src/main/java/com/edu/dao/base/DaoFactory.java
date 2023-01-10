package com.edu.dao.base;

import com.edu.dao.academic.TableNameDao;
import com.edu.dao.academic.impl.TableNameDaoImpl;
import com.edu.myproject.*;

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

    // 下面可以加更多的Dao对象,如下
//    public ScoreDao getScoreDao(){return new ScoreDaoImpl(); }
    public resultDao getResultDao(){return new resultDaoImpl();}

    public auditDao getAuditDao(){return new auditDaoImpl();}

    public assistant_assessmentDao getAssistant_assessmentDao(){return new assistant_assessmentDaoImpl();}
}
