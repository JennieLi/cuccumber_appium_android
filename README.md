Cucumber Appium Java (Android Example)

This project Demo BDD tests on Android device as example, using Cucumber-jvm, Appium. 

This project comes with:

* Test app (based on Google's Android Tutorial http://developer.android.com/training/index.html)
* Example feature file
* Example step definitions.

[Prerequisites]: 

(This has been tested on the following system.)
Windows 7
Java 1.7
Android SDK 22.2.1
Ant Version 1.8.1
node.js 1.3.11
Appium 1.2.1 (http://appium.io/)
Android Device/Emulator (Android Version 4.2.2)

[Steps]:

* Connect Android device

adb devices
appium &

* Specifiy the App/APK  to be tested.

Put the apk file under apks/ folder, and confirm the values of APP_DIR, APK_NAME correct in conf/config.properties.

* Start cucumber test. (If need update the cucumber feature file)
cd .../path/of/root/folder (like Cucumber_Appium_Android, which build.xml locates in.)
ant runcukes

* Check junit test reports and cucumber html report in target/ folder.