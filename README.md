# VetPy - Pet Management Application

## Overview

VetPy is an Android-based pet management application developed using Kotlin. The application aims to simplify pet care by providing a centralized platform where users can manage their pet's health records, appointments, lost pet reports, and other essential services. VetPy offers a user-friendly interface with robust features designed to streamline pet care management.

---

## Features

🐶 Pet Profiles

- Create and manage profiles for pets, including name, breed, age, and gender.
  
![petprofile](https://github.com/user-attachments/assets/9f15aa10-de23-4d3e-ba44-f75c23fb0198)

### 🏥 Pet Care Services

- Select your pet category, or book a bath for your favorite animal.
- 
![services](https://github.com/user-attachments/assets/1a120fec-6382-4e53-bea1-29d5714fbedf)


### 🔐 User Authentication

- Secure login and registration system.
- Social media login integration (Google, Facebook) for quick access.
![userauth](https://github.com/user-attachments/assets/ce2a3743-51ba-4560-9da4-e7b486bab7e9)



### 🛒 Pet Products Marketplace

- Browse and purchase pet-related products such as food, toys, and accessories.
- Secure checkout and order tracking system.
  
![products](https://github.com/user-attachments/assets/a8bcc06c-aca1-460d-8e9d-535dc1df3d86)

### 👤 User Profile

- Display personal user information, including name, location, number, email.
  
![userprofile](https://github.com/user-attachments/assets/c5bc8d67-88ce-443a-b252-bd4b868dc912)

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




