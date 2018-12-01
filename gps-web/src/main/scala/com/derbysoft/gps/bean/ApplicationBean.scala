package com.derbysoft.gps.bean

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ApplicationBean {

  val logger = LoggerFactory.getLogger(classOf[ApplicationBean])


  @Bean def scalaModule: Module = new DefaultScalaModule
  @Bean def jodaModule: Module = new JodaModule
  @Bean def jdkModule: Module = new Jdk8Module



}
