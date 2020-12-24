/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataServer;

import java.util.ArrayList;

import notification.NotificationTemplates;

/**
 *
 * @author kerols
 */
public interface IData {
    public void add(NotificationTemplates template);
    public void delete(int id);
    public void update(NotificationTemplates template);
    public ArrayList<NotificationTemplates> getData( );
    public NotificationTemplates getTemplate(int id);
}
