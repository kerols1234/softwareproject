package dataServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.EmailQueue;

public class QueueEmail implements QueuingEmail {

	private Connection connection;
    
    private void setConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/notification" + "?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=converttonull&serverTimezone=GMT", "username", "password");
    }
	
	@Override
	public void add(EmailQueue email) {
		try {
            setConnection();
            String query = "INSERT INTO email_queue(id, id_of_template, sender, receiver) VALUES ('" +
            		email.getId() +
                    "','" +
                    email.getIdOfTemplate() +
                    "','" +
                    email.getSender() +
                    "','" +
                    email.getReceiver() +
                    "')";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaveTemplates.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	public void delete(int id) {
		try {
            setConnection();
            String query = "DELETE FROM email_queue WHERE id = " + id;
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaveTemplates.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
