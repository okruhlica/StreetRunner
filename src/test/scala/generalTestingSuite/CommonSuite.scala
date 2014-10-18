package generalTestingSuite

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import workout.RouteLoader
import workout.Route
import io._
import reverseGeo.StreetResolverGoogle
import com.typesafe.config.ConfigFactory

@RunWith(classOf[JUnitRunner])
class CommonSuite extends FunSuite {

  test("Setting from app configuration is accessible & loaded.") {
    val config = ConfigFactory.load
    lazy val apiKey = config.getString("geocoding.api.google.key")
    assert(!apiKey.isEmpty())
  }
}
