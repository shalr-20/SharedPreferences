# Shared Preferences in Android - NewsNow

Shared Preferences in Android provide a lightweight mechanism to store and retrieve small amounts of key-value pair data. This is especially useful for persisting **user settings**, **app configurations**, and **UI state** across sessions.

## 🔤 Language Selection
Shared Preferences are used to manage **language preferences**. Once a user selects a preferred language:
- The language choice is stored using Shared Preferences.
- UI elements and text across the application reflect the selected language.
- Enhances overall **user experience** and **accessibility**.

## ⚙️ Configuration in `build.gradle.kts`
Enable **View Binding** to simplify interaction with UI components:

```kotlin
buildFeatures {
    viewBinding = true
}
```

- Reduces boilerplate code.
- Ensures type safety with UI components.

## 🔄 App State Persistence
Shared Preferences help persist the **app state**, such as:
- A **toggle switch** being turned ON.
- A **TextView** position or content.

These preferences are retained **even after the app is closed or restarted**, ensuring a seamless and consistent user experience.

---

### Example Code Snippet
```kotlin
// Saving data
val sharedPref = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
with (sharedPref.edit()) {
    putString("language", "en")
    apply()
}

// Retrieving data
val language = sharedPref.getString("language", "en")
```

Feel free to explore and contribute to improving language support and user personalization!


<a href="https://github.com/user-attachments/assets/f095af4c-6186-454b-aa15-a3d2eb95c4cb" alt="Watch the video"> </a>
