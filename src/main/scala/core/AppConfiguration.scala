package core

import com.typesafe.config.ConfigFactory

object AppConfiguration {
	val configuration = ConfigFactory.load
}