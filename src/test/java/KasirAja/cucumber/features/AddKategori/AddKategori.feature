Feature: Login functionality

Scenario Outline: Ensure login functionality
 Given user is on KasirAja login page
  When user input <email> as email
  And  user input <password> as password
  When user click submit
  Then user click kategori button
  And  user click tambah button
  When user fill or not filling nama field
  And  user click simpan
  Then user verify <status> add kategori


  Examples:

  |email|password|status|
  |feriashen@naraka.com|feriashen|success|
