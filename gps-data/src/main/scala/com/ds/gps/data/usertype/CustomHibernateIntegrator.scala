package com.ds.gps.data.usertype

import org.hibernate.boot.Metadata
import org.hibernate.boot.spi.MetadataImplementor
import org.hibernate.cfg.Configuration
import org.hibernate.engine.config.spi.ConfigurationService
import org.hibernate.engine.spi.SessionFactoryImplementor
import org.hibernate.integrator.spi.Integrator
import org.hibernate.service.spi.SessionFactoryServiceRegistry
import org.hibernate.usertype.UserType

class CustomHibernateIntegrator extends Integrator {
  private val REGISTER_USER_TYPES_KEY = "derby.autoRegisterUserTypes"

  private val USER_TYPES = Array[UserType](new JodaDateTimeUserType(), new JodaLocalDateUserType(), new PropertiesType())


  def integrate(configuration: Configuration, sessionFactory: SessionFactoryImplementor, serviceRegistry: SessionFactoryServiceRegistry): Unit = {
    val isEnabled = configuration.getProperty(REGISTER_USER_TYPES_KEY)
    if (isEnabled.toBoolean) {
      USER_TYPES.map(f => configuration.registerTypeOverride(f, null))
    }
  }


  override def integrate(metadata: Metadata, sessionFactory: SessionFactoryImplementor, serviceRegistry: SessionFactoryServiceRegistry): Unit = {
    if (!metadata.isInstanceOf[MetadataImplementor])
      throw new IllegalArgumentException("Metadata was not assignable to MetadataImplementor: " + metadata.getClass)
    val mi = metadata.asInstanceOf[MetadataImplementor]
    val service = serviceRegistry.getService(classOf[ConfigurationService])
    val autoRegister = service.getSettings.get(REGISTER_USER_TYPES_KEY).asInstanceOf[String]
    if (autoRegister.toBoolean) autoRegisterUsertypes(mi)
  }


  private def registerType(mi: MetadataImplementor, `type`: UserType): Unit = {
    val className = `type`.returnedClass.getName
    mi.getTypeResolver.registerTypeOverride(`type`, Array[String](className))
  }

  private def autoRegisterUsertypes(configuration: MetadataImplementor): Unit = {
    for (next <- USER_TYPES) {
      registerType(configuration, next)
    }
  }

  override def disintegrate(sessionFactory: SessionFactoryImplementor, serviceRegistry: SessionFactoryServiceRegistry): Unit = {}
}
