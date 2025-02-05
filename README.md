# VetPy - Pet Management Application

## Overview

VetPy is an Android-based pet management application developed using Kotlin. The application aims to simplify pet care by providing a centralized platform where users can manage their pet's health records, appointments, lost pet reports, and other essential services. VetPy offers a user-friendly interface with robust features designed to streamline pet care management.

![Home Screen UI](https://imgur.com/aujL5h1)

---

## Features

🐶 Pet Profiles

- Create and manage profiles for pets, including name, breed, age, and gender.

![Imgur](https://imgur.com/f25GTeQ)

### 🏥 Pet Care Services

- Select your pet category, or book a bath for your favorite animal.


![Service Booking UI](https://imgur.com/aE01MlJ)

### 🔐 User Authentication

- Secure login and registration system.
- Social media login integration (Google, Facebook) for quick access.

![User Authentication UI](https://imgur.com/a/knabaXo)

### 🛒 Pet Products Marketplace

- Browse and purchase pet-related products such as food, toys, and accessories.
- Secure checkout and order tracking system.

![Pet Products UI](https://imgur.com/rsVXkXk)

### 👤 User Profile

- Display personal user information, including name, location, number, email.
- Update account settings and security preferences.

![User Profile UI](https://imgur.com/8vLuuVe)

---

## Folder Structure

The project follows a modular architecture for maintainability and scalability:

```
main/
├── java/com.example.prueba/
│   ├── database/
│   │   ├── Gender
│   │   ├── PetModelDao
│   │   ├── PetModelDatabase
│   │   ├── PetSpecies
│   ├── model/
│   │   ├── PetModel
│   │   ├── ProductModel
│   ├── viewmodel/
│   │   ├── AdapterClass
│   │   ├── BathCareServices
│   │   ├── CatServices
│   │   ├── Dashboard
│   │   ├── DataClass
│   │   ├── DialogAdapter
│   │   ├── DogServices
│   │   ├── HamsterServices
│   │   ├── LostAdapter
│   │   ├── LostPetProfile
│   │   ├── LostPets
│   │   ├── MainActivity
│   │   ├── PetInfo
│   │   ├── PetProfile
│   │   ├── Pets
│   │   ├── ProductAdapter
│   │   ├── ProductProvider
│   │   ├── Services
│   │   ├── UserProfile
├── res/
│   ├── drawable/
│   ├── layout/
```

---

## Installation

To run the VetPy application locally, follow these steps:

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/vetpy.git
   cd vetpy
   ```
2. **Open the project in Android Studio.**
3. **Run the application on an emulator or physical device.**

---



## Contact

### Author: Isaias Candia
### Email: isaias.candia.dev@gmail.com




