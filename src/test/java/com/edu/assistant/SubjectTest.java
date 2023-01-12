package com.edu.assistant;

import com.edu.dao.base.DaoFactory;
import com.edu.dao.common.SubjectDao;
import com.edu.domain.common.Subject;
import org.junit.Test;

import java.util.List;

/**
 * SubjectTest : SubJect测试类
 */
public class SubjectTest {

    SubjectDao subjectDao = DaoFactory.getInstance().getSubjectDao();
    @Test
    public void testSelectAll(){
        List<Subject> list = subjectDao.selectallSubject();
        System.out.println(list);
        for(Subject sub : list){
            System.out.println(sub);
        }
    }
}
