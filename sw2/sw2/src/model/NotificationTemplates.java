package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kerols
 */
@XmlRootElement (name="NotificationTemplates") 
public class NotificationTemplates {
    private int id;
    private String data;
    private String name;
    private String language;
    private String subject;

    public NotificationTemplates(int id, String data, String name, String language, String subject) {
        this.id = id;
        this.data = data;
        this.name = name;
        this.language = language;
        this.subject = subject;
    }

    public NotificationTemplates(String data, String name, String language, String subject) {
        this.data = data;
        this.name = name;
        this.language = language;
        this.subject = subject;
    }
    
    public NotificationTemplates() {
    }
    
    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
