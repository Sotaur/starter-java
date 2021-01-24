package com.twilio.starter.controller

import com.twilio.rest.api.v2010.account.Call
import spark.Route
import com.twilio.starter.controller.CallController
import com.twilio.type.PhoneNumber
import spark.Request
import spark.Response
import java.net.URI

object CallController {
    private val TWILIO_PHONE_NUMBER = System.getenv("TWILIO_PHONE_NUMBER")
    var handlePost = Route { request: Request, response: Response? ->
        // Get POST data
        val to = request.queryParams("to")
        Call.creator(
                PhoneNumber(to),
                PhoneNumber(TWILIO_PHONE_NUMBER),
                URI.create("http://demo.twilio.com/docs/voice.xml"))
                .create()
        "Call is inbound!"
    }
}