# Clean Code Assessment

<br>

## Overview
Clean Code Assessment is a Kotlin project that includes recommended practices require for setup
complicated application in way which is easy to understand and easy to change as the project grows.
It separates the elements of a design into ring levels and on the inner layers can have
no knowledge of functions on the outer layers.

## Architecture Followed

This project demonstrate the how data is managed through API to the view model, how views are observing
for model data changes for rendering purpose. So the architecture is around MVVM pattern.

![](readme-diagram.png)

<br>

## Main Libraries Used

- Kotlin  (https://developer.android.com/kotlin)

- Coroutines  https://developer.android.com/kotlin/coroutines

- Retrofit  https://square.github.io/retrofit/

- Koin (Dependency Injection) https://insert-koin.io/


<br>

## Uses NYTimes API for fetching newsfeed

API Docs: https://developer.nytimes.com/apis
Uses https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=  API as network end points.

<br>

## Getting Started

- Clone and import in studio.
- Sync & Build the project so it will download required dependencies.
- Create latest AVD and run the project

<br>
## Run through Terminal

For Build creation
./gradlew clean assembleDevDebug

To Build & Run
./gradlew clean installDevDebug OR
adb install app/build/outputs/apk/dev/debug/app-dev-debug.apk

<br>
## Demo

![](demo.gif)


# Clean Code Assessment
