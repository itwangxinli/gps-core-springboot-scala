package com.derbysoft.gps.data

import org.hibernate.dialect.InnoDBStorageEngine

class InnodbUtf8StorageEngine extends InnoDBStorageEngine {
  val INSTANCE = new InnodbUtf8StorageEngine()

  override def getTableTypeString(engineKeyword: String): String = super.getTableTypeString(engineKeyword) + "  default charset 'utf-8'"
}
