package com.derbysoft.gps


import java.awt.image.BandedSampleModel

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
  * Hello world!
  *
  */

object App {
  def main(args: Array[String]): Unit = {
    val app = new SpringApplication(classOf[Config])
    app.setBannerMode(Banner.Mode)

  }
}
