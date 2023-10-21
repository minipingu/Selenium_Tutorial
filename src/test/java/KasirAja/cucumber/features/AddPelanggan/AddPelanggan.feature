Feature: Tambah pelanggan functionality

Scenario Outline: Ensure tambah pelanggan functionality
 Given user is on KasirAja login page
  When user input <email> as email
  And  user input <password> as password
  When user click submit
  Then user click pelanggan button
  And  user click tambah button
  When user fill or not filling <nama_pelanggan> as nama_pelanggan
  And  user click simpan
  Then user verify <status> add <nama_pelanggan>


  Examples:

  |email               |password |status |nama_pelanggan|
  |feriashen@naraka.com|feriashen|success|minipingu|
  |feriashen@naraka.com|feriashen|failed ||
