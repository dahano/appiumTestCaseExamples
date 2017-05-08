# Appium Test Case Examples

## Summary
- 1 Happy path test running against Appium v1.6.4
- The test is written against an Android emulator

## XPath's do no make for good locator markers and neither do coordinates
 - That being said, some of the instances where I use XPath's or Coordinates are the only (semi) reliable way to hit that element.
 - My suggestion is to always sit down with developers and ask for a more reliable hook such as a unique resource ID.


## Testing Steps:
1) Open CarGurus App
2) Select make of BMW
3) Select Model of 2 Series
4) Fill in Zip Code
5) Search Used Cars Filter
6) Find a 2015 M235i in Black
7) Select First Result
8) Share car via email to email@address.com
