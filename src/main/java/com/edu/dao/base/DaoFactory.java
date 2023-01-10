package com.edu.dao.base;

import com.edu.dao.*;
import com.edu.dao.academic.TableNameDao;
import com.edu.dao.academic.impl.TableNameDaoImpl;

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
    //用户Dao
    public UserDaoImpl getUserDao(){return new UserDaoImpl();}

    //用户角色Dao
    public User_RoleDaoImpl getUser_RoleDao(){return new User_RoleDaoImpl();}

    //导师Dao
    public TutorDaoImpl getTutorDao(){return new TutorDaoImpl();}

    //研究生Dao
    public PostgraduateDaoImpl getPostgraduateDao(){return new PostgraduateDaoImpl();}

    //项目Dao
    public ProjectDaoImpl getProjectDao(){return new ProjectDaoImpl();}
    //参与项目Dao
    public ParticipateDaoImpl getParticipateDao(){return new ParticipateDaoImpl();}

    public Subject_LeaderDaoImpl getSubject_LeaderDao(){return new Subject_LeaderDaoImpl();}
}
