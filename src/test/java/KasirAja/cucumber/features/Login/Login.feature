Feature: Login functionality

Scenario Outline: Ensure login functionality
 Given user is on KasirAja login page
  When user input <email> as email
  And user input <password> as password
  When user click submit
  Then user verify <status> login result

  Examples:

  |email|password|status|
  |feriashen@naraka.com|feriashen|success|
  |feriashen@naraka.com|feriashensalah|failed|