package com.twilio.starter.controller

import com.twilio.twiml.VoiceResponse
import com.twilio.twiml.voice.Say
import spark.Request
import spark.Response
import spark.Route

object TwimlController {
    // Render a TwiML document to give instructions for an outbound call
    var handlePost = Route { request: Request?, response: Response ->
        val one = Say.Builder("Hello there! You have successfully configured a web hook.").build()
        val two = Say.Builder("Good luck on your Twilio quest!").build()
        val voiceResponse = VoiceResponse.Builder().say(one).say(two).build()
        response.type("text/xml")
        voiceResponse.toXml()
    }
}