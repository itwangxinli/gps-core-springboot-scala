package com.derbysoft.gps.data.base

import javax.persistence.{Entity, Table, UniqueConstraint}
import lombok.{AllArgsConstructor, NoArgsConstructor}
import org.joda.time.LocalDate

import scala.beans.BeanProperty

@Entity
@Table(uniqueConstraints = Array(new UniqueConstraint(columnNames = Array("cityCode"))))
@AllArgsConstructor
@NoArgsConstructor
class ScalaCity extends Base {
  @BeanProperty
  var cityCode: String = _

  @BeanProperty
  var cityName: String = _

  @BeanProperty
  var date: LocalDate = _
}



