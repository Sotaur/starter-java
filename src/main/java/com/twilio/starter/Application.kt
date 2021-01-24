package com.twilio.starter

import com.twilio.Twilio
import com.twilio.starter.controller.CallController
import com.twilio.starter.controller.MessageController
import com.twilio.starter.controller.TwimlController
import spark.Spark.post
import spark.Spark.staticFileLocation

@Suppress("UNUSED_PARAMETER")
fun main(args: Array<String>) {
    Application().main()
}

class Application {
    private val ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID")
    private val AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN")

   fun main() {
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN)

       staticFileLocation("/public")

       post("/call", CallController.handlePost)
       post("/message", MessageController.handlePost)
       post("/hello", TwimlController.handlePost)
   }
}