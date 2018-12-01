package com.derbysoft.gps.data.usertype

import java.io
import java.io.Serializable

import org.hibernate.usertype.UserType

trait AbstractUserType extends UserType {

  override def equals(x: AnyRef, y: AnyRef): Boolean = x == y

  override def hashCode(x: AnyRef): Int = x.hashCode()

  override def clone(): AnyRef = super.clone()

  override def deepCopy(value: AnyRef): AnyRef = value

  override def isMutable: Boolean = false

  override def assemble(cached: io.Serializable, owner: AnyRef): AnyRef = cached.asInstanceOf[AnyRef]

  override def disassemble(value: AnyRef): io.Serializable = value.asInstanceOf[Serializable]


  override def replace(original: AnyRef, target: AnyRef, owner: AnyRef): AnyRef = deepCopy(original)

}
