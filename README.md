# Login & SignUp with Firebase + Notepad

This repository contains a **Kotlin-based** Android application that implements **Login and Sign-Up functionality using Firebase Authentication**. After authentication, users can access a **Notepad** feature to create, save, and manage their notes.

## Features
- User registration using **email and password**
- User login with Firebase Authentication
- Notepad feature to **add, edit, and delete notes**
- Error handling for authentication failures
- Firebase backend integration for authentication

## Tech Stack
- **Kotlin** (Android development)
- **Firebase Authentication**
- **Android Jetpack Components**

## Screenshots
(Add screenshots of your app here)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/HUSAINTRIVEDI52/Login_SignUp_FireBase.git
   ```
2. Open the project in **Android Studio**
3. Connect the project to Firebase:
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new project
   - Enable **Authentication** and select **Email/Password**
   - Download the `google-services.json` file and place it in the `app/` directory
4. Build and run the app on an emulator or a physical device

## Usage
1. Open the app
2. Register using an email and password
3. Log in with the registered credentials
4. After logging in, access the **Notepad** feature to create and manage notes
5. Save and edit notes as needed

## Firebase Setup
Ensure you have:
- Enabled **Email/Password Authentication** in Firebase Authentication
- Added **google-services.json** to the project
- Configured Firebase dependencies in `build.gradle`:
  ```gradle
  dependencies {
      implementation 'com.google.firebase:firebase-auth:21.0.1'
      implementation 'com.google.firebase:firebase-database:20.0.4'
  }
  ```

## Contributing
Feel free to fork the repository and submit pull requests with improvements or bug fixes.



 Contact
For any queries or issues, feel free to reach out at 768379853

