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

package uk.gov.hmrc.ui.specs

import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.pages.{CookiesPage, EnglishCookiesPage, OnlineServicesTermsPage, TermsAndConditionsPage}

import java.net.URI

class HelpFrontendSpec extends BaseSpec {

  Feature("Help") {

    Scenario("Navigate to the cookies page") {
      Given("I go to the English version of the cookies page")
      EnglishCookiesPage.goTo()

      Then("I am shown the cookies page")
      EnglishCookiesPage.pageTitle() shouldBe "Cookies – GOV.UK"

      And("I am shown cookie related content")
      EnglishCookiesPage.cookiesInfoText shouldBe "Small files (known as ‘cookies’) are put onto your computer to collect information about how you browse the site."
    }

    Scenario("Navigate to the terms and conditions page") {
      Given("I go to the terms and conditions page")
      TermsAndConditionsPage.goTo()

      Then("I am shown the terms and conditions page")
      TermsAndConditionsPage.pageTitle() should be("Terms and conditions – GOV.UK")

      And("I am shown terms and conditions related content")
      TermsAndConditionsPage.disclaimerText() shouldBe "Disclaimer"

      And("I am shown links to related content")
      TermsAndConditionsPage.links().map(url => new URI(url)).map(_.getPath) shouldBe List(
        "/help/privacy",
        "/help/terms-and-conditions",
        "/help/terms-and-conditions/online-services",
        "/security/index.htm",
        "/copyright/index.htm",
        "/terms/agents.htm",
        "/help/privacy",
        "/contact/report-technical-problem"
      )
    }

    Scenario("Navigate to the online services terms and conditions page") {
      Given("I go to the online services terms and conditions page")
      OnlineServicesTermsPage.goTo()

      Then("I am shown the online services terms and conditions page")
      OnlineServicesTermsPage.pageTitle() shouldBe "HMRC Online Services Terms & Conditions – GOV.UK"

      And("I am shown online services terms and conditions related content")
      OnlineServicesTermsPage.subHeadings().toList shouldBe List(
        "All individuals, organisations and agents",
        "Additional points for individuals",
        "Additional points for organisations",
        "Additional points for agents, accountant and representatives",
        "All Shared Workspace users"
      )

      And("I am shown links to related content")
      OnlineServicesTermsPage.links().map(url => new URI(url)).map(_.getPath) shouldBe List(
        "/online/index.htm",
        "/about/privacy.htm",
        "/information/helpdesk",
        "/security/index.htm",
        "/copyright/",
        "/channelsPortalWebApp/channelsPortalWebApp.portal",
        "/information/helpdesk",
        "/manuals/swmanual/SW03370.htm",
        "/terms/",
        "/contact/report-technical-problem"
      )
    }

  }

}
