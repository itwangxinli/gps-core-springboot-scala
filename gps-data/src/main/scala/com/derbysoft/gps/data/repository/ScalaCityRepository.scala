package com.derbysoft.gps.data.repository

import com.derbysoft.gps.data.base.ScalaCity
import org.springframework.data.repository.CrudRepository

trait ScalaCityRepository extends CrudRepository[ScalaCity, Long] {
  def findByCityCode(cityCode: String): ScalaCity
}
