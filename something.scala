package controllers

import play.api.mvc._
import play.api.db._

class SafeSqlController @Inject()(db: Database) extends Controller {
  
  // Whitelist validation — only alphanumeric usernames allowed
  private def sanitize(input: String): Option[String] = {
    if (input.matches("^[a-zA-Z0-9]+$")) Some(input) else None
  }
  
  def getUser(username: String) = Action {
    sanitize(username) match {
      case Some(safeUsername) =>
        db.withConnection { conn =>
          val stmt = conn.createStatement()
          val rs = stmt.executeQuery(
            "SELECT * FROM users WHERE username = '" + safeUsername + "'"
          )
          Ok(rs.getString(1))
        }
      case None => BadRequest("Invalid username")
    }
  }
}
