Feature: SignUp functionality

Scenario Outline: Ensure SignUp functionality
 Given user is on KasirAja login page
 When user click signup link
 And user input <name> as name
 When user input <email> as email
 And user input <password> as password
 When user click submit
 Then user verify <status> signup result

 Examples:

 |name                   |email               |password |status|
 |Toko Senjata Feria Shen|feriashen@naraka.com|feriashen|success|
 |Toko Senjata Feria Shen|feriashen@gmail.c   |feriashen|wrong email|