Feature: Validation of GetPlace API

Scenario: Validate that new place get added to map API

Given User configure baseURI with place_ID
When User hits GetPlace API with GET httprequest
Then User gets status code as 200
And User gets address in response body as "29, side layout, cohen 09"
