package dataServer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import notification.NotificationTemplates;

/**
 *
 * @author kerols
 */
public class DataBaseSQL implements IData{

    private Connection connection;
    
    private void setConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/notification" + "?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=converttonull&serverTimezone=GMT", "username", "password");
    }
    
    @Override
    public void add(NotificationTemplates template) {
        try {
            setConnection();
            String query = "INSERT INTO template(data, template_name, language, subject) VALUES ('" +
                    template.getData() +
                    "','" +
                    template.getName() +
                    "','" +
                    template.getLanguage() +
                    "','" +
                    template.getSubject() +
                    "')";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            setConnection();
            String query = "DELETE FROM template WHERE id = " + id;
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NotificationTemplates template) {
        try {
            setConnection();
            String query = "UPDATE template SET data='"
                    + template.getData()
                    + "',template_name='"
                    + template.getName()
                    + "',language='"
                    + template.getLanguage()
                    + "',subject='"
                    + template.getSubject()
                    + "' WHERE id="
                    + template.getId();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<NotificationTemplates> getData() {
        try {
            ArrayList<NotificationTemplates> list = new ArrayList<>();
            setConnection();
            Statement stmt = connection.createStatement();
            String stat = "SELECT id, data, template_name, language, subject FROM template";
            ResultSet res = stmt.executeQuery(stat);
            ResultSetMetaData rsmd = res.getMetaData();
            int c = rsmd.getColumnCount();
            while (res.next()) {
               list.add(new NotificationTemplates(Integer.parseInt(res.getString(1)),
                       res.getString(2),
                       res.getString(3),
                       res.getString(4),
                       res.getString(5))) ;
            }
            connection.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public NotificationTemplates getTemplate(int id) {
        try {
            setConnection();
            NotificationTemplates t = null;
            Statement stmt = connection.createStatement();
            String stat = "SELECT id, data, template_name, language, subject FROM template WHERE id = " + id;
            ResultSet res = stmt.executeQuery(stat);
            ResultSetMetaData rsmd = res.getMetaData();
            int c = rsmd.getColumnCount();
            while (res.next()) {
               t = new NotificationTemplates(Integer.parseInt(res.getString(1)),
                       res.getString(2),
                       res.getString(3),
                       res.getString(4),
                       res.getString(5)) ;
            }
            connection.close();
            return t;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
