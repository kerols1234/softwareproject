package API;

import java.util.ArrayList;
import model.NotificationTemplates;

public interface ITemplateApi {
	ArrayList<NotificationTemplates> getTemplates();
	NotificationTemplates getTemplate(int id);
	void remove(int id);
	void add(NotificationTemplates t);
	void update(NotificationTemplates t);
}
