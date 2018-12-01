package com.derbysoft.gps.data.base


import javax.persistence._
import org.joda.time.DateTime

import scala.beans.BeanProperty

@MappedSuperclass
class Base {


  @BeanProperty
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = _

  @BeanProperty
  @Column(updatable = false)
  var createdTime: DateTime = _

  @BeanProperty
  var lastModifyTime: DateTime = _

  @PrePersist
  @PreUpdate
  def init(): Unit = {
    if (createdTime == null)
      setCreatedTime(DateTime.now())
    setLastModifyTime(DateTime.now)
  }

  @Version
  var version: Integer = _
}
