# Appium Test Demo for AWS Device Farm

A minimal Appium test demo for AWS Device Farm. This project is intended to be used as a starting point for creating your own Appium tests to run on AWS Device Farm.

### Build the project using Maven

```bash
mvn clean package -DskipTests=true
```

- Upload the generated `target/zip-with-dependencies.zip` file to AWS Device Farm when creating a new test run. 
- Make sure to select the appropriate test type (Appium Java TestNG) and provide the necessary configuration for your tests.
- Also, allure report is integrated in this project.
- Check the testng.xml file for the test spec.

### Notes
- I've configured the project to integrate Appium tests with AWS Device Farm. See in pom.xml. You can also see Docs in https://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-appium-integrate.html
- You just need to build the project and use the generated zip file to upload to AWS Device Farm. 
