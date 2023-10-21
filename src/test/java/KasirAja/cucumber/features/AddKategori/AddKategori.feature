Feature: Tambah kategori functionality

Scenario Outline: Ensure tambah kategori functionality
 Given user is on KasirAja login page
  When user input <email> as email
  And  user input <password> as password
  When user click submit
  Then user click kategori button
  And  user click tambah button
  When user fill or not filling <nama_kategori> as nama_kategori
  And  user click simpan
  Then user verify <status> add <nama_kategori>


  Examples:

  |email               |password |status |nama_kategori|
  |feriashen@naraka.com|feriashen|success|dual pistol|
  |feriashen@naraka.com|feriashen|failed ||
