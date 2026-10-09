// Save as SqlController.scala
package controllers

import play.api.mvc._
import play.api.db._

class SqlController @Inject()(db: Database) extends Controller {
  def getUser(username: String) = Action {
    db.withConnection { conn =>
      val stmt = conn.createStatement()
      val rs = stmt.executeQuery(
        "SELECT * FROM users WHERE username = '" + username + "'"
      )
      Ok(rs.getString(1))
    }
  }
}
