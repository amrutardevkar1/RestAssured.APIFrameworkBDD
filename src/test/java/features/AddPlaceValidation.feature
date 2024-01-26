Feature: AddPlace validation API test

Scenario: Validate that new place is added to MAP when user hits AddPlace API

Given User created BaseURI and attach payload
When User hits AddPlace resource with POST httprequest
Then User gets response with status code 200
And User gets response with "status" equals to "OK"
And User gets response with "scope" equals to "APP"