package notification;

import dataServer.DataBaseSQL;

import java.util.ArrayList;

/**
 *
 * @author kerols
 */
public class TemplateAPI {
	
    private dataServer.DataBaseSQL dbsql = new DataBaseSQL();

    public TemplateAPI() {
    }
    
    public ArrayList<NotificationTemplates> getTemplates() {
        return dbsql.getData();
    }
    
    public void remove(int id){
        dbsql.delete(id);
    }
    
    public void update(NotificationTemplates t){
        dbsql.update(t);
    }
    
    public void add(NotificationTemplates t){
        dbsql.add(t);
    }
}
