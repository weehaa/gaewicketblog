package org.gaewicketblog.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AppEngineHelper {

	private final static Logger log = LoggerFactory.getLogger(AppEngineHelper.class);

	public static boolean isAdmin(String adminemail) {
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        if (user != null) {
        	log.debug("user="+user.toString());
        	return adminemail.equalsIgnoreCase(user.getEmail());
        }
		return false;
	}

}
