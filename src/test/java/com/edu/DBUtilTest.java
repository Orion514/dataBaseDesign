import com.edu.druid.DBUtil;
import com.edu.search.impl.StudentSearchCriteria;
import org.junit.Test;

public class DBUtilTest {

    @Test
    public void test() {
        String a = DBUtil.fixSqlFieldValue("3333'" );
        System.out.println(a);
    }

    @Test
    public void testSearch(){
        StudentSearchCriteria s = new StudentSearchCriteria("19",null,"男",null,null);
        System.out.println(s.getSearchSql());
    }

}
