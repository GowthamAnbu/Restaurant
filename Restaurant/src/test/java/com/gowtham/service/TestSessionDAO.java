package com.gowtham.service;

import java.time.LocalTime;

import com.gowtham.dao.SessionDAO;
import com.gowtham.model.Session;

public class TestSessionDAO {

	public static void main(String[] args) {
		Session session = new Session();
		session.setId(5);
		session.setName("Party");
		session.setStartTime(LocalTime.parse("23:00:00"));
		session.setEndTime(LocalTime.parse("23:10:00"));
		
		SessionDAO sessionDAO = new SessionDAO();
		sessionDAO.save(session);
		sessionDAO.update(5, LocalTime.parse("23:30:00"), LocalTime.parse("00:00:00"));
		sessionDAO.delete(5);
		sessionDAO.list();

	}

}
