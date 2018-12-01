package com.ds.gps.data.repository

import com.ds.gps.data.base.ScalaCity
import org.springframework.data.repository.CrudRepository

trait ScalaCityRepository extends CrudRepository[ScalaCity, Long] {
  def findByCityCode(cityCode: String): ScalaCity
}
