## 3.0.0 (2024-03-12)

### BREAKING CHANGE

- Testing Bump

## 2.0.4 (2024-03-01)

## 2.0.2 (2024-01-19)

## 2.0.0 (2023-08-25)

## 1.2.12 (2023-07-26)

### Feat

- update aws versions to be correct and spacelibs to 1.1.7.1-SNAPSHOT
- 🎸 Some stuff
- update exception, remove unneeded import, update deprecated code
- update exception handler for constraint violations, update gradle
- update jsoup
- make default symbol empty instead of single quote
- add join and test for string utils to join collections and arrays
- update xss filter to leave & < > " alone
- finish testing entity util and baseservice
- update entityutil to handle dto to entity conversion with referenced entities
- **annotation**: removed annotations applied to work with timeline as they were too granular
- **codes**: added new action type codes for cloning and reordering
- version 1.1.4-SNAPSHOT
- **misc**: misc changes and fixes
- **null check**: add handle for null array
- **enumutil**: add toStringList conversion and test
- add handler to catch all other exceptions
- **services**: adding items to the BaseService class, including an annotation for post proc
- finish test
- save
- add base entity and dto with dynamic type selection
- **base classes**: add base service and repo with tests
- **null**: handle null class input, update tests
- test for entityUtil null case
- add handle for class<?> being null
- **list convert**: add conversion for entity list into dto list
- **test null**: handle null inputs
- **test**: finish entityUtil testing
- work on entityutil test
- **test**: add test for ClassUtil
- add comment
- add comment
- **entity convert**: add entity to dto conversion
- **classutil**: add class util with some reflection tools
- **hijackfilter**: impelmented the hijack filter to support the current format for responses
- **valiation**: authrentication validation for the user's session to chack IP and User Agent
- **error handling**: updatated the error handling to account for Spring specific errors
- **import**: move import back
- **context**: fix application context to load beans correctly
- **log**: add logs to exception handler
- **attributes**: add attributes into parser factory
- **oo**: added Abstract methods and class for the validaiton parsers
- **javadocs**: updated the config to use the lombok generated code for javadocs
- **factory to dispatch parser/packager**: parser interface, factory and abstract bytearray parser
- **ossh-01**: Remove unneeded class, add usage for factory, change enum for number validator.
- **utils**: moved the entity util from EZ Form to spacelibs-java
- **build adjust**: remove <p/> tags, update build.gradle to build snapshots and releases
- **tokens**: added the ability to create validate and open valid JWT tokens
- **validate**: added a Aspect template for the validation
- **validation**: added the jsoup and ESAPI validation ot the request wrapper validaotr
- **security**: added the base auth and validation classes
- **cleanup utils**: performed cleanup and added enum util features
- **image rotation**: added ability to rotate images
- **image**: added an image rotation class to the libs
- **utils**: added the ability to epad a string to the left or the right
- **cleanup**: fixed issues with date style rendering and added unit test for a date format
- **io**: added a stream utility with a method to stream reports to the browseer
- **reports**: finished coding and testing the new reports package of code
- added class for random functionality and unit test respectively
- **unit tests**: continuing to create the unit tests for the excel reports
- **reports**: adding the Excel report code form WebCrescendo
- **weather**: copied over the weather sunrise/Sunset code
- initial date format library
- **weather**: implementing the unit tests for the weather app
- **weather**: adding the weather libraries
- **time zone**: added capability to display and utilize time zones
- **boolean utils**: added a class and unit test for the boolean utils class
- **overriden method**: added an additional overridden method for integers
- **number util**: added the numberfomrmatter class to convert strings into various primitives
- **gradle**: updated the gradle config to build jacoco reports
- **unit testing**: completed 100% coverage of the http manager unit testing
- **unit tests**: continuing to build unit tests for smthttpconnectionmanager
- **connections**: adding the SMTHttpCOnnectionManager to the SpaceLibs repo with unit test
- **test**: finalized code and unit tests for the Tree class
- **data**: adding the tree and node classes to the libs
- **phonenumber**: added the formatting for phone numbers
- **initialization**: initializing the project with some code and classes

### Fix

- update jsoup to 1.15.3 for dependency check
- **encoding**: fixed encoding issue when filter throws an error.  StringUtil updated to serialize
- **dependencycheck**: remove unused exception and validator
- update class to be from the field instead of the value, fixes a proxy object issue
- **cleanup**: fixed serialVersionUID issue with entity to dto conversion
- **ossh-01**: add test to ensure that too large numbers are handled properly
- **sonarlint**: fixed issues with sonarqube after connecting to P1 instance
- **json**: fixed filter to process json objects correctly.  Added unit tests
- **dependencies**: updated some of the imports to remove dependency check issues
- **codes fixes**: code fixes to factory, validators, dateformat
- **validation factory**: code changes to parserfactory, streamparser
- **ossh-01**: change regex to DoS safe version
- **ossh-01**: tweak regex to capture entire phrase
- **ossh-01**: tweak regex to be ddos safe
- 🐛 Removing a log
- 🐛 Renaming ApiRequestResponses
- **ossh-01**: remove unused @return annotation
- **ossh-01**: tweak private constructors
- **ossh-01**: return to using ApiRequestException
- **ossh-01**: mergefix upstream
- **ossh-01**: deal with SonarLint issues, tweak tests, and general cleanup
- **ossh-01**: mergefix with admin fork feature-ossh-01
- **ossh-01**: add comment on builderMapper
- **ossh-01**: add testing class for the factory parser
- **ossh-01**: return deleted line
- **ossh-01**: add final testing classes
- **ossh-01**: add missing comments and delete unused file
- **ossh-01**: change alternate id to a boolean
- **ossh-01**: fix comments
- **ossh-01**: clean up tests and add comments
- **ossh-01**: remove unneeded tests
- **ossh-01**: finalize options validation, add tests for them, and add tests for xss filter
- **ossh-01**: change how options are handled
- **ossh-01**: add an options validator as well as an other option bypass
- **ossh-01**: add test coverage for validation
- **ossh-01**: fix some testing issues, clean up git requests
- **ossh-01**: move xss filter to it's own class.'
- **ossh-01**: update tests
- **ossh-01**: fix issues with uuid and email validators, change to throw errros on validate fail
- **ossh-01**: fix issues with using around instead of before
- **ossh-01**: fix issue with attributes map not being properly brought in to the parser factory
- **ossh-1**: update to match new packager code and add email and uuid validators
- **fix parser factory**: fixed parser factory
- **deleted builder package and class**: deleted builder package replaced with tag in validationdto
- **ossh-01**: integrate packager factory
- **ossh-01**: get validation aop wired up to validate properly and strip potential xss from the body
- **OSSH-01**: Quick fix to match changes to validate annotation to new aop.
- **OSSH-01**: Mergefix upstream
- **OSSH-01**: Fix minor issues discovered during git review.
- **OSSH-01**: Return deleted file.
- **OSSH-01**: Add builder annotation to DTOs and change over error creation to use the builder.
- **OSSH-01**: Add junit test class for the validation code.
- **OSSH-01**: Complete validators, adding proper parsign checks and fixing issues with factory.
- **ossh-01**: Create factory, util, and DTOs for the validation process.
- 🐛 Updating the gradle name to match
- **name cahnge**: updated gradle files with the new repo name
- **review**: fixed issues requested from code review
- **dates**: fixed issue with date formatting on the spreadsheet
- **pr review**: updated and combined some methods based upon Tim's review

### Refactor

- remoe unused import, add more info to exception
- commented out unused handler, to be filled when unknown exceptions get added
- add serializable uid
- **validationparser**: added methods to make validation dtos and add to list
- 💡 Renaming ApiRequestException to
- final editting
- few changes
- minute naming changes
- made few changes, added a method
- **marathon-spaceforce-01**: made few documentation and date data storage changes
