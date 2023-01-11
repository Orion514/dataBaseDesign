package com.edu.dao.academic_exchange;

import com.edu.po.Academic_Exchange;
import com.edu.dao.academic_exchange.Academic_ExchangeDao;
import com.edu.dao.base.DaoBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Academic_ExchangeDaoImpl extends DaoBase implements Academic_ExchangeDao {
    private static final String insert_sql="insert into academic_exchange" +
            "(student_id,activity_name,location,time,report_name,image,notes,subject_leader_id)" +
            "values(?,?,?,?,?,?,?,?)";
    private static final String select_sql="select * from academic_exchange";
    private static final String update_sql1="update academic_exchange set audit_result=? where" +
            " student_id=? and no=?";
    private static final String update_sql2="update academic_exchange set audit_result=? where" +
            " student_id=? and audit_result=?";
    @Override
    public void addAcademic_Exchange(Academic_Exchange academic_exchange) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(insert_sql);
            preparedStatement.setString(1,academic_exchange.getStudent_id());
            preparedStatement.setString(2,academic_exchange.getActivity_name());
            preparedStatement.setString(3,academic_exchange.getLocation());
            preparedStatement.setDate(4, new java.sql.Date(academic_exchange.getTime().getTime()));
            preparedStatement.setString(5,academic_exchange.getReport_name());
            preparedStatement.setString(6,academic_exchange.getImage());
            preparedStatement.setString(7,academic_exchange.getNotes());
            preparedStatement.setString(8,academic_exchange.getSubject_leader_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAcademic_Exchange() {

    }

    @Override
    public void updateAcademic_Exchange1(String student_id,int no,String audit_result) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(update_sql1);
            preparedStatement.setString(2,student_id);
            preparedStatement.setInt(3,no);
            preparedStatement.setString(1,audit_result);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAcademic_Exchange2(String student_id, String audit_result) {
        try {
            Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(update_sql2);
            preparedStatement.setString(2,student_id);
            preparedStatement.setString(1,audit_result);
            preparedStatement.setString(3,"待审核");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Academic_Exchange> selectAcademic_Exchange() {
        List<Academic_Exchange> list=new ArrayList<>();
        try {
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(select_sql);
            while(resultSet.next()){
                Academic_Exchange academic_exchange=new Academic_Exchange();
                academic_exchange.setStudent_id(resultSet.getString(1));
                academic_exchange.setNo(resultSet.getInt(2));
                academic_exchange.setActivity_name(resultSet.getString(3));
                academic_exchange.setLocation(resultSet.getString(4));
                academic_exchange.setTime(resultSet.getTimestamp(5));
                academic_exchange.setReport_name(resultSet.getString(6));
                academic_exchange.setImage(resultSet.getString(7));
                academic_exchange.setNotes(resultSet.getString(8));
                academic_exchange.setSubject_leader_id(resultSet.getString(9));
                academic_exchange.setAudit_result(resultSet.getString(10));
                list.add(academic_exchange);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
