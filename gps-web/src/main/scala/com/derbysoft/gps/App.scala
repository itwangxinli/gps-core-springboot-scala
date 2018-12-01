package com.derbysoft.gps


import org.springframework.boot.{Banner, SpringApplication}

/**
  * Hello world!
  *
  */

object App {
  def main(args: Array[String]): Unit = {
    val app = new SpringApplication(classOf[Config])
    app.setBannerMode(Banner.Mode.OFF)
    app.run(args: _*)
  }
}
