Feature: verify Google Serach

Scenario: verify by input data in google search
Given intialize browser with chrome
And navigate to the "google" site
When user enters some input "Ravi" in searchbox
Then Search should be appeared
