package com.ds.gps.data.usertype

import java.sql.{PreparedStatement, ResultSet, Types}
import java.util.Properties

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import org.hibernate.`type`.TextType
import org.hibernate.engine.spi.SharedSessionContractImplementor

class PropertiesType extends AbstractUserType {

  override def sqlTypes(): Array[Int] = Array(java.sql.Types.VARCHAR)

  override def nullSafeGet(rs: ResultSet, names: Array[String], session: SharedSessionContractImplementor, owner: scala.Any): AnyRef = {
    val josnText = TextType.INSTANCE.nullSafeGet(rs, names, session, owner).asInstanceOf[String]
    if (josnText == null) return null
    else return JSON.parseObject(josnText, returnedClass)
  }


  override def nullSafeSet(st: PreparedStatement, value: scala.Any, index: Int, session: SharedSessionContractImplementor): Unit = {
    if (value == null) st.setNull(index, Types.NULL)
    else st.setString(index, JSON.toJSONString(value.asInstanceOf[Properties],SerializerFeature.PrettyFormat))
  }

  override def returnedClass(): Class[Properties] = classOf[Properties]
}
