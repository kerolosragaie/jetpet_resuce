<h1 align="center">Jet Pet Rescue App</h1>

[![Linkedin: kerollosragaie](https://img.shields.io/badge/-kerollosragaie-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/kerollos-ragaie-youssef-b9529aa6/)](https://www.linkedin.com/in/kerollos-ragaie/)
[![GitHub Kerollos Ragaie](https://img.shields.io/github/followers/kerolosragaie?label=follow&style=social)](https://github.com/kerolosragaie)

## Description

Jet Pet Rescue App is a cutting-edge repository that serves as a comprehensive and interactive learning resource for developers interested in mastering Jetpack Compose, Retrofit, and the seamless integration of the Coil image loading library.

## Deep links:
#### Note: Unfortunately I don't have any domain (website) to host.
> So the best solution is to implment deep links locally on the device using ADB (Android Debug Bridge) using any local domain (https://wwww.likander.com).


"https://www.likander.com/details_screen/:petId" => Runs details screen

### Let's test deep links
> For sure if tryed to launch the app from any browser on the device it will not open because 'https://www.likander.com' is a local host (dummy url), so the best solution to test if deep links works or no, I will call ADB and give it the local host 'https://www.likander.com' and my app package name 'hoods.com.jetpetrescue' like below:

1. Download and run the project using Android Studio and in the terminal type below line and press enter:

```Kotlin
adb shell 'am start -a android.intent.action.VIEW -c android.intent.category.BROWSABLE -d "https://www.likander.com/details_screen/3' hoods.com.jetpetrescue
```
2. And Details Screen will open.

## Screenshots

![Screenshot 1](screenshots/screen2.png)
![Screenshot 2](screenshots/screen3.png)
