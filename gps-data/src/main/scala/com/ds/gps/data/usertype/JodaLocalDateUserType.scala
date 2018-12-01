package com.ds.gps.data.usertype

import java.sql.{PreparedStatement, ResultSet}

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.joda.time.LocalDate

class JodaLocalDateUserType extends AbstractUserType {
  lazy val sqlTypes: Array[Int] = Array(java.sql.Types.DATE)

  override def nullSafeGet(rs: ResultSet, names: Array[String], session: SharedSessionContractImplementor, owner: scala.Any): LocalDate = {
    val dateTime = rs.getString(names.head)
    if (dateTime != null) LocalDate.parse(dateTime) else null
  }

  override def nullSafeSet(st: PreparedStatement, value: Any, index: Int, session: SharedSessionContractImplementor): Unit = {
    if (value != null) {
      st.setObject(index, value.asInstanceOf[LocalDate].toString())
    } else {
      st.setNull(index, java.sql.Types.NULL)
    }
  }

  lazy val returnedClass: Class[_] = classOf[LocalDate]
}
