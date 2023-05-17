# Lab - Retrofit -  MVVM

- https://github.com/HarshitaBambure/Retrofit



## Travail à faire

- Refaire le tutoriel video
    - [KOTLIN Retrofit Tutorial | Part 1 | Simple GET Request | For Beginners | Easiest Way to API Call](https://www.youtube.com/watch?v=5gFrXGbQsc8)


## Retrofit-with-recyclerview

- https://www.youtube.com/watch?v=3oW-NDMFebg
- https://github.com/Bhavy-idea/Retrofit-with-recyclerview/tree/master



## Configuration

````xml
    <uses-permission android:name="android.permission.INTERNET" />
````

````
plugins {
    id 'kotlin-kapt'
}

````

````
android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //Navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'
    
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
}
````



# Références

- https://github.com/HarshitaBambure/Retrofit

- https://medium.com/@umang.burman.micro/androids-mvvm-architecture-in-kotlin-ft-retrofit-6acc22cabfc6
  - https://github.com/umangburman/MVVM-Retrofit-Kotlin-Example
- https://square.github.io/retrofit/
- [JSONPlaceholder](https://jsonplaceholder.typicode.com/)
- [KOTLIN Retrofit Tutorial | Part 1 | Simple GET Request | For Beginners | Easiest Way to API Call](https://www.youtube.com/watch?v=5gFrXGbQsc8)