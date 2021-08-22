package com.appdevlopment.app.ws.userservice;

import com.appdevlopment.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appdevlopment.app.ws.ui.model.responce.UserRest;

public interface UserService {
UserRest createUser(UserDetailsRequestModel userDetails);
}
