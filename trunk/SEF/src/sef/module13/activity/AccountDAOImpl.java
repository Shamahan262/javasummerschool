package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		
		return null;
	}

	public Account findAccount(int id) throws AccountDAOException {

		
		return null;
	}


	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {

		
		return false;
	}

}
