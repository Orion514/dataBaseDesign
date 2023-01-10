package com.edu.dao;

import com.edu.po.Participate;

import javax.servlet.http.Part;
import java.util.List;


public interface ParticipateDao {
    public Participate getParticipateByPostgraduateId(String postgraduate_id);

    public void AddParticipate(Participate participate);

    public void UpdateParticipate(Participate participate);

    public List<Participate> getAllParticipate();

    public void DeleteParticipate(String postgraduate_id);
}
