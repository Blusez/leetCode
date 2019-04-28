package com.example.demo.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping
@Slf4j
public class TestController {
	RateLimiter rateLimiter = RateLimiter.create(2);

	/**
	 * @api {get} /user/:id Request User information
	 * @apiName GetUser
	 * @apiGroup User
	 * @apiParam {Number} id Users unique ID.
	 * @apiSuccess {String} firstname Firstname of the User.
	 * @apiSuccess {String} lastname  Lastname of the User.
	 * @apiSuccessExample Success-Response:
	 * <p>
	 * HTTP/1.1 200 OK
	 * <p>
	 * {
	 * <p>
	 * "firstname": "John",
	 * <p>
	 * "lastname": "Doe"
	 * <p>
	 * }
	 * @apiError UserNotFound The id of the User was not found.
	 * @apiErrorExample Error-Response:
	 * <p>
	 * HTTP/1.1 404 Not Found
	 * <p>
	 * {
	 * <p>
	 * "error": "UserNotFound"
	 * <p>
	 * }
	 */

	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	@ResponseBody
	public Object policy() {

		if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
			log.error("限流了");
			return "error";
		}
		//try {
		//	//TimeUnit.SECONDS.sleep(5);
		//} catch (InterruptedException e) {
		//	log.error("error");
		//}
		log.info("正常访问");
		return "正常访问";


	}
}
