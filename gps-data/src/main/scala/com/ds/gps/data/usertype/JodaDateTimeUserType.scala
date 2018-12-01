package com.ds.gps.data.usertype

import java.sql.{PreparedStatement, ResultSet}

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class JodaDateTimeUserType extends AbstractUserType {


  val dateTimePattern = "yyyy-MM-dd HH:mm:ss"
  val dateTimeFormatter = DateTimeFormat.forPattern(dateTimePattern)


 lazy val returnedClass: Class[DateTime] = classOf[DateTime]


  lazy val sqlTypes: Array[Int] = Array(java.sql.Types.TIMESTAMP)

  override def nullSafeGet(rs: ResultSet, names: Array[String], session: SharedSessionContractImplementor, owner: scala.Any): DateTime = {
    val dateTime = rs.getTimestamp(names.head)
    if (dateTime != null) {
      return new DateTime(dateTime);
    } else null
  }

  override def nullSafeSet(st: PreparedStatement, value: Any, index: Int, session: SharedSessionContractImplementor): Unit = {
    if (value != null) {
      st.setObject(index, value.asInstanceOf[DateTime].toString(dateTimePattern))
    } else {
      st.setNull(index, java.sql.Types.NULL)
    }
  }


}
