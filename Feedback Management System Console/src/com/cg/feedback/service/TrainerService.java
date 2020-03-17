<<<<<<< HEAD:Feedback Management System Console/src/com/cg/feedback/service/TrainerService.java
package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerService extends UserService{
	void showFeedBack() throws CustomException;
	void showDefaulters() throws CustomException;
}
=======
package com.cg.feedback.service;

import com.cg.feedback.exceptions.CustomException;

public interface TrainerService extends UserService{
	String showFeedBack() throws CustomException;
	String showDefaulters() throws CustomException;
}
>>>>>>> f1464cfd9260bfbb1bf2cabd5579c30419673198:Feedback Management System Console/src/com/cg/feedback/service/TrainerService.java
