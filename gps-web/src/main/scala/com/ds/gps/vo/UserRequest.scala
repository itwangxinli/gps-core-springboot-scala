package com.ds.gps.vo

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName("data")
case class UserRequest(name: String, password: String)
