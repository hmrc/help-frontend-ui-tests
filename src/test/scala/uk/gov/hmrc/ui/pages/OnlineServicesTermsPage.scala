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
import scala.jdk.CollectionConverters.CollectionHasAsScala

object OnlineServicesTermsPage extends BasePage {

  override protected val url: String = TestEnvironment.url("help-frontend") + "/terms-and-conditions/online-services"

  def withLang(lang: String): BasePage = new BasePage {
    override val url: String =
      TestEnvironment.url("help-frontend") + s"/terms-and-conditions/online-services?lang=$lang"
  }

  def subHeadings(): Seq[String] = {
    val subHeadingElements = webDriver.findElements(By.className("govuk-heading-l")).asScala
    subHeadingElements.toSeq.map(_.getText)
  }

  def languageOfPage(): String = webDriver
    .findElement(By.tagName("html"))
    .getAttribute("lang")

  def switchLanguageToEnglish(): Unit = click(By.partialLinkText("English"))

  def switchLanguageToWelsh(): Unit = click(By.partialLinkText("Cymraeg"))

}
