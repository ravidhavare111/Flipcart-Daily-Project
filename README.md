# Flipkart Daily Inventory Management System 🛒

A simplified inventory management REST API system built using Java and Spring Boot.  
This project simulates an e-commerce backend that handles inventory additions, stock updates, brand-based product searches, and inventory summary reports.

---

## 🚀 Features

- 📦 Add new items to the inventory (brand, category, price)
- 📦 Add quantity for existing items in the inventory (brand, category, quantity)
- ➕ Update inventory stock for existing products
- 🔍 Search items by brand name (case-insensitive, sorted by price)
- 📊 Get an inventory summary (all products sorted by price)
- ✅ Lightweight in-memory implementation (no database)

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- RESTful APIs
- JUnit 5 for unit testing

---

## 📁 Project Structure

Expect data is coming in JSON format:
JSOn dzta syntax:
1.addItem
POST /addItem
Body: {
"brandName": "Apple",
"category": "Phone",
"price": 999,
}

2.addInventory
POST /addInventory
Body: {
"brandName": "Apple",
"category": "Phone",
"quantity": 3
}

3.searchItems by {brandName
GET /searchItems/{brandName}

4.getInventorySummary
GET /getInventorySummary




📝 Author
Ravi Dhavare
Backend Java Developer | Spring Boot Enthusiast
🌐 LinkedIn https://www.linkedin.com/in/ravi-dhavare-85b515104/
📧 ravidhavare111@gmail.com


This project is open source and available for all and contribution.
