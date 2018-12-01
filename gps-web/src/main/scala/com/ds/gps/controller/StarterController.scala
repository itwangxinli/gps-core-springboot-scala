package com.ds.gps.controller

import com.ds.gps.data.base.{Base, ScalaCity}
import com.ds.gps.data.repository.ScalaCityRepository
import com.ds.gps.vo.UserRequest
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._


@RestController
class StarterController {
  @Autowired
  var cityRepository: ScalaCityRepository = _

  @GetMapping(Array("/"))
  def home = {
    val base = new Base
    base.setId(0)
    val city = cityRepository.findByCityCode("City")
    if (city == null) {
      val city2 = new ScalaCity()
      city2.setCityCode("City")
      city2.cityName="City"
      city2.date = LocalDate.now()
      cityRepository.save(city2)
    }

    UserRequest("wang", "123456")

  }

  @PostMapping(Array("/user-request/save"))
  def saveUserRequest(@RequestBody userRequest: UserRequest) = userRequest
}