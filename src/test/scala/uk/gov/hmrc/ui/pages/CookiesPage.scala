/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment

sealed trait CookiesPage extends BasePage {

  override protected val url: String = TestEnvironment.url("help-frontend") + "/cookie-details"

  def cookiesInfoText(): String = getText(By.id("cookies-info"))

  def otherLanguage: String

  def switchLanguage(): Unit = click(By.partialLinkText(otherLanguage))

  def hasLanguageSwitchingLink(): Boolean =
    !webDriver.findElements(By.partialLinkText(otherLanguage)).isEmpty
}

object EnglishCookiesPage extends CookiesPage {
  val otherLanguage: String  = "Cymraeg"
  val cookiesHeading: String = "Cookies"
}

object WelshCookiesPage extends CookiesPage {
  val otherLanguage: String  = "English"
  val cookiesHeading: String = "Cwcis"
}
