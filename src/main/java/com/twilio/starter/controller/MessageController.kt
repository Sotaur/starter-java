package com.twilio.starter.controller

import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import spark.Request
import spark.Response
import spark.Route

object MessageController {
    private val TWILIO_PHONE_NUMBER = System.getenv("TWILIO_PHONE_NUMBER")
    var handlePost = Route { request: Request, response: Response? ->
        // Get POST data
        val to = request.queryParams("to")
        Message.creator(
                PhoneNumber(to),
                PhoneNumber(TWILIO_PHONE_NUMBER),
                "Good luck on your Twilio quest!")
                .create()
        "Message incoming!"
    }
}