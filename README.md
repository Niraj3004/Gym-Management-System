
# Gym Membership Management System 💪 (Java GUI Project).

A user-friendly Java application to manage gym members, built using Object-Oriented Programming principles. This project supports both **Regular** and **Premium** membership types with functionalities like attendance tracking, payment handling, membership upgrade, and more.

---

## 🚀 Features

- 🧍 Add and manage **Regular** and **Premium** members
- 📆 Track member **attendance** and calculate **loyalty points**
- 💸 Handle **payment** and **discounts** (for premium members)
- 🔁 **Upgrade** regular members to better plans
- ❌ Reset or remove member profiles
- 🧑‍🏫 Object-Oriented design using **inheritance, abstraction, encapsulation**
- 🎨 GUI version (Coming Soon or Already Integrated - you can update this)

---

## 🧱 Classes Overview

### ✅ `GymMember` (Abstract)
Base class containing:
- Common attributes (id, name, contact info, etc.)
- Abstract method `markAttendance()`
- Methods to activate, deactivate, reset, and display member info

### 💎 `PremiumMember` (extends GymMember)
- Has `personalTrainer`, payment status, and discount features
- Tracks attendance and rewards with **10 points**
- Handles **payment** and **discount calculation**

### 🧾 `RegularMember` (extends GymMember)
- Includes plan (Basic, Standard, Deluxe) with pricing
- Has attendance limits and upgrade eligibility
- Tracks attendance and rewards with **5 points**

---

## 📷 Screenshots (Optional)
_Add screenshots of your GUI or CLI interface here._

---

## 📦 Requirements

- Java JDK 8 or higher
- Any IDE like IntelliJ IDEA, Eclipse, or NetBeans

---


