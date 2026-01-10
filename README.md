# ProFolio - Android Portfolio App

A beautiful portfolio app built with **Jetpack Compose** for Android, converted from the Angular web portfolio.

## Features

- 🎨 **Modern UI** - Dark theme with gradient backgrounds and animations
- 📱 **Native Android** - Built with Jetpack Compose and Material 3
- 🔄 **Smooth Navigation** - Bottom navigation with scroll sync
- ✨ **Animations** - Particle effects, progress animations, and more
- 📊 **Skills Section** - Categorized skills with progress bars
- 💼 **Projects Section** - Expandable project cards with features
- 👔 **Experience Section** - Timeline-based professional history
- 📧 **Contact Section** - Direct email and social links

## Project Structure

```
pro-folio-android/
├── app/
│   ├── src/main/
│   │   ├── java/com/younes/profolio/
│   │   │   ├── data/
│   │   │   │   ├── model/          # Data classes
│   │   │   │   └── repository/     # Data repository
│   │   │   ├── ui/
│   │   │   │   ├── components/     # Composable UI components
│   │   │   │   ├── screens/        # Screen composables
│   │   │   │   └── theme/          # App theme (colors, typography)
│   │   │   └── MainActivity.kt
│   │   ├── res/                    # Android resources
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
│   └── libs.versions.toml          # Version catalog
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Requirements

- Android Studio Hedgehog (2023.1.1) or later
- JDK 11 or later
- Android SDK 35 (API level 35)
- Minimum SDK: 24 (Android 7.0)

## Getting Started

1. **Open in Android Studio**
   ```
   File > Open > Select pro-folio-android folder
   ```

2. **Sync Gradle**
   - Android Studio will automatically sync the project
   - Wait for the sync to complete

3. **Run the App**
   - Connect an Android device or start an emulator
   - Click the Run button or press `Shift+F10`

## Build

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

## Dependencies

- **Jetpack Compose** - Modern Android UI toolkit
- **Material 3** - Material Design 3 components
- **Navigation Compose** - Navigation component for Compose
- **Coil** - Image loading library
- **Kotlin Coroutines** - Asynchronous programming

## Customization

### Update Personal Information
Edit `PortfolioRepository.kt` to update:
- Personal info (name, email, description)
- Skills and their levels
- Projects and features
- Professional experience
- External links

### Theme Colors
Modify colors in `Color.kt`:
- `PrimaryColor` - Main brand color
- `SecondaryColor` - Accent color
- `DarkBackground` - Background color
- And more...

## Screenshots

The app features:
- Hero section with animated avatar ring and particles
- Skills section with category tabs and progress bars
- Projects section with expandable cards
- Experience timeline
- Contact section with quick actions

## License

MIT License - Feel free to use this for your own portfolio!
<!-- .\gradlew bundleRelease 2>&1 -->
## Author

**Younes MRABTI**
- GitHub: [@ymrabti](https://github.com/ymrabti)
- LinkedIn: [younesmrabti1996](https://linkedin.com/in/younesmrabti1996)
