package sef.module13.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernards Gulbis
 * 
 */
public class AccountDAOImpl implements AccountDAO {

	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public List<Account> findAccount(String firstName, String lastName)
			throws AccountDAOException {
		List<Account> accountList = new ArrayList<Account>();
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("SELECT * FROM `activity`.`account` "
							+ "WHERE UPPER(first_name) = ? OR UPPER(last_name) = ? "
							+ "ORDER BY id ASC");
			pStmt.setString(1, firstName.toUpperCase());
			pStmt.setString(2, lastName.toUpperCase());

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Account account = new AccountImpl(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4));
				accountList.add(account);
			}

		} catch (Exception e) {
			throw new AccountDAOException(AccountDAOException.ERROR_FIND_NAME,
					e);
		}

		return accountList;
	}

	public Account findAccount(int id) throws AccountDAOException {	
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("SELECT * FROM `activity`.`account` WHERE id = ?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (rs.first()) {
				return new AccountImpl(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw new AccountDAOException(AccountDAOException.ERROR_FIND_ID, e);
		}
	}

	public boolean insertAccount(String firstName, String lastName, String email)
			throws AccountDAOException {
		try {
			PreparedStatement pStmt = conn
					.prepareStatement("INSERT INTO `activity`.`account` " +
							"(first_name, last_name, e_mail) " +
							"VALUES(?, ?, ?)");
			pStmt.setString(1, firstName);
			pStmt.setString(2, lastName);
			pStmt.setString(3, email);
			if (pStmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new AccountDAOException(AccountDAOException.ERROR_INSERT_ACCOUNT, e);
		}
	}

}
