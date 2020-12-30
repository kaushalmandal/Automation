Feature: User Registration
  
  Scenario: user registration with different sets of data
  Given user is on registration page
  When user enter following user details
  | kauhsal | Mandal | Dhanbad |
  | kajal | Mandal | Bhuli |
  Then user registration is successfull
