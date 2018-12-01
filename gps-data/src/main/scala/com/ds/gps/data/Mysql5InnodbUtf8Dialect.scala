package com.ds.gps.data

import org.hibernate.dialect.{InnoDBStorageEngine, MySQL55Dialect}

class Mysql5InnodbUtf8Dialect extends MySQL55Dialect {

  override def getDefaultMySQLStorageEngine = InnoDBStorageEngine.INSTANCE

}
