# Projet JPA - Java Persistence API Learning Project

A comprehensive educational project demonstrating progressive JPA (Java Persistence API) concepts using Hibernate, designed for students learning database persistence in Java.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
  - [Part 1: Basic CRUD Operations](#part-1-basic-crud-operations)
  - [Part 2: Many-to-Many Relationships](#part-2-many-to-many-relationships)
  - [Part 3: Embedded Objects & Collections](#part-3-embedded-objects--collections)
  - [Part 4: Inheritance Strategies](#part-4-inheritance-strategies)
  - [Part 5: Native SQL Queries](#part-5-native-sql-queries)
  - [Part 6: JPQL & Named Queries](#part-6-jpql--named-queries)
- [Database Schema](#database-schema)
- [Learning Objectives](#learning-objectives)
- [Technologies Used](#technologies-used)
- [Authors](#authors)

## Overview

This project uses a **municipal governance domain model** (Mayors, Communes, Departments) to demonstrate various JPA concepts across 6 progressive lessons. Each part focuses on specific JPA features, building upon previous knowledge to provide a comprehensive understanding of Java persistence.

**Target Audience**: Computer Science students learning enterprise Java development and ORM (Object-Relational Mapping) patterns.

## Features

### Part 1: Basic CRUD Operations
- Create, Read, Update, Delete operations on entities
- One-to-One relationships (Maire � Commune)
- Many-to-One relationships (Commune � Departement)
- One-to-Many relationships (Departement � Communes)
- Composite primary keys with `@EmbeddedId`
- Entity lifecycle management

### Part 2: Many-to-Many Relationships
- Join table entities with composite keys
- Bidirectional many-to-many relationships
- Managing temporal data in relationships (date ranges)

### Part 3: Embedded Objects & Collections
- `@Embedded` objects for value types
- `@ElementCollection` for basic type collections
- Cascade operations with embedded objects
- Collection ordering with `@OrderBy`

### Part 4: Inheritance Strategies
- `@MappedSuperclass` inheritance pattern
- Entity hierarchy and polymorphism
- Inherited field mapping

### Part 5: Native SQL Queries
- Direct SQL execution via `createNativeQuery()`
- Aggregate functions (COUNT, SUM)
- Parameter binding in native queries
- Result set processing

### Part 6: JPQL & Named Queries
- JPQL (Java Persistence Query Language) queries
- `@NamedQuery` annotations
- Type-safe queries with `TypedQuery`
- JOIN operations and aggregations
- Bulk operations (DELETE, UPDATE)
- Case-insensitive searching

## Project Structure

```
Projet-JPA/
   pom.xml                                    # Maven build configuration
   src/
      main/
         java/tn/ensit/info3/glid/projet_jpa/
            App.java                       # Part 1 - Basic CRUD
            AppPartie2.java                # Part 2 - Many-to-Many
            AppPartie3.java                # Part 3 - Embedded objects
            AppPartie4.java                # Part 4 - Inheritance
            AppPartie5.java                # Part 5 - Native queries
            AppPartie6.java                # Part 6 - JPQL queries
            model/                         # Part 1 entities
               Civilite.java              # Enum: M, Mme
               Maire.java                 # Mayor entity
               Commune.java               # Municipality entity
               Departement.java           # Department entity
               Classe.java                # Class entity (composite key)
               ClePrimaireClasse.java     # Embeddable composite key
            model_partie2/                 # Part 2 - Join table entities
            model_partie3/                 # Part 3 - Embedded entities
            model_partie4_heritage/        # Part 4 - Inheritance entities
            model_partie6_jpa/             # Part 6 - Named query entities
         resources/
             META-INF/
                 persistence.xml            # JPA configuration
      test/
          java/
              AppTest.java                   # Unit tests
   README.md                                  # This file
```

## Prerequisites

Before running this project, ensure you have:

- **Java Development Kit (JDK) 17** or higher
- **Apache Maven 3.6+** for dependency management
- **MySQL 8.0+** database server
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

## Installation

### 1. Clone the Repository

```bash
git clone <repository-url>
cd Projet-JPA
```

### 2. Set Up MySQL Database

Create the required databases and user:

```sql
-- Create databases
CREATE DATABASE bd_glid_2025;
CREATE DATABASE bd_glid_2025_partie2;
CREATE DATABASE bd_glid_2025_partie3;
CREATE DATABASE bd_glid_2025_partie4;
CREATE DATABASE bd_glid_2025_partie6;

-- Create user and grant privileges
CREATE USER 'app_glid_2025'@'localhost' IDENTIFIED BY 'app_glid_2025';
GRANT ALL PRIVILEGES ON bd_glid_2025.* TO 'app_glid_2025'@'localhost';
GRANT ALL PRIVILEGES ON bd_glid_2025_partie2.* TO 'app_glid_2025'@'localhost';
GRANT ALL PRIVILEGES ON bd_glid_2025_partie3.* TO 'app_glid_2025'@'localhost';
GRANT ALL PRIVILEGES ON bd_glid_2025_partie4.* TO 'app_glid_2025'@'localhost';
GRANT ALL PRIVILEGES ON bd_glid_2025_partie6.* TO 'app_glid_2025'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Build the Project

```bash
mvn clean install
```

## Configuration

The project uses `persistence.xml` located at `src/main/resources/META-INF/persistence.xml` to configure 5 persistence units:

| Persistence Unit | Database | Schema Action |
|------------------|----------|---------------|
| `exemple1` | `bd_glid_2025` | update |
| `exemple2` | `bd_glid_2025_partie2` | update |
| `exemple3` | `bd_glid_2025_partie3` | update |
| `exemple4` | `bd_glid_2025_partie4` | update |
| `exemple6` | `bd_glid_2025_partie6` | create-drop |

**Connection Settings:**
- **URL**: `jdbc:mysql://localhost:3306/<database>`
- **Driver**: `com.mysql.cj.jdbc.Driver`
- **Username**: `app_glid_2025`
- **Password**: `app_glid_2025`

To modify database credentials, edit `persistence.xml`:

```xml
<property name="jakarta.persistence.jdbc.user" value="your_username"/>
<property name="jakarta.persistence.jdbc.password" value="your_password"/>
```

## Usage

### Part 1: Basic CRUD Operations

Run the main application to explore basic CRUD operations:

```bash
mvn exec:java -Dexec.mainClass="tn.ensit.info3.glid.projet_jpa.App"
```

**Features demonstrated:**
- `ecrire()` - Create a new mayor with user input
- `chercher()` - Find mayor by ID
- `modifier()` - Update mayor information
- `supprimer()` - Delete mayor by ID
- `creerCommune()` - Create commune with associated mayor
- `chercherCommune()` - Retrieve commune and its mayor

**Entity Relationships:**
- `Maire` � `Commune` (One-to-One bidirectional)
- `Commune` � `Departement` (Many-to-One)
- `Departement` � `Communes` (One-to-Many)

**Example Code:**
```java
// Create EntityManager
EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemple1");
EntityManager em = emf.createEntityManager();

// Create a new mayor
em.getTransaction().begin();
Maire maire = new Maire("Dupont", "Jean", Civilite.M);
em.persist(maire);
em.getTransaction().commit();

// Find by ID
Maire found = em.find(Maire.class, 1L);
System.out.println(found.getNom());
```

### Part 2: Many-to-Many Relationships

Demonstrates join table pattern with temporal data:

```bash
mvn exec:java -Dexec.mainClass="tn.ensit.info3.glid.projet_jpa.AppPartie2"
```

**Key Concepts:**
- `CommuneMaire` join entity with composite key
- Tracking start/end dates for relationships
- Bidirectional many-to-many associations

### Part 3: Embedded Objects & Collections

Run to see embedded objects and element collections:

```bash
mvn exec:java -Dexec.mainClass="tn.ensit.info3.glid.projet_jpa.AppPartie3"
```

**Features:**
- `demoComposition()` - Embedded address objects within mayors
- `demoCollections()` - Element collections for email addresses

**Example:**
```java
// Create mayor with embedded address
Maire maire = new Maire("Martin", "Sophie", Civilite.Mme);
Adresse adresse = new Adresse("123 Rue de la Paix", commune);
maire.setAdresse(adresse);

// Add email collection
Set<String> emails = new HashSet<>();
emails.add("sophie.martin@mairie.fr");
maire.setEmails(emails);
```

### Part 4: Inheritance Strategies

Demonstrates `@MappedSuperclass` inheritance:

```bash
mvn exec:java -Dexec.mainClass="tn.ensit.info3.glid.projet_jpa.AppPartie4"
```

**Inheritance Hierarchy:**
```
Utilisateur (@MappedSuperclass)
       Employe (@Entity)
```

**Example:**
```java
Employe employe = new Employe();
employe.setNom("Durand");
employe.setSalaire(35000.0);
em.persist(employe);
```

### Part 5: Native SQL Queries

Execute native SQL queries:

```bash
mvn exec:java -Dexec.mainClass="tn.ensit.info3.glid.projet_jpa.AppPartie5"
```

**Methods:**
- `afficherNombreMaires()` - Count total mayors
- `afficherNomsAdressesMaires()` - List names and addresses
- `afficherNomAdressMaire()` - Find specific mayor

**Example:**
```java
// Native SQL with parameter binding
String sql = "SELECT * FROM maire WHERE nom = :nom";
Query query = em.createNativeQuery(sql, Maire.class);
query.setParameter("nom", "Dupont");
List<Maire> results = query.getResultList();
```

### Part 6: JPQL & Named Queries

Advanced querying with JPQL:

```bash
mvn exec:java -Dexec.mainClass="tn.ensit.info3.glid.projet_jpa.AppPartie6"
```

**Features:**
- `afficherMaires()` - Retrieve all mayors
- `afficherDepartementPopulation()` - Aggregate queries with JOIN
- `afficherStatistiquesCommunes()` - Statistics with COUNT/SUM
- `supprimerMaires()` - Bulk delete operations

**Example JPQL:**
```java
// Type-safe JPQL query
TypedQuery<Maire> query = em.createQuery(
    "SELECT m FROM Maire m WHERE LOWER(m.nom) LIKE :pattern",
    Maire.class
);
query.setParameter("pattern", "%dupont%");
List<Maire> results = query.getResultList();

// Named query usage
TypedQuery<Commune> query = em.createNamedQuery("Commune.byName", Commune.class);
query.setParameter("nom", "Paris");
Commune commune = query.getSingleResult();
```

## Database Schema

### Part 1 Schema (bd_glid_2025)

**Tables:**
- `maire` (id, nom, prenom, civilite, commune_id)
- `commune` (id, nom, departement_id)
- `departement` (id, nom)
- `classe` (niveau, annee, nombreEE) - Composite key

**Constraints:**
- UNIQUE(nom, prenom) on maire table
- Foreign keys with cascade options

### Part 3 Schema (bd_glid_2025_partie3)

**Additional Fields:**
- `maire.adresse_adresse` - Embedded address string
- `maire.adresse_commune_id` - Embedded commune reference
- `maire_emails` - Collection table for email addresses

### Key Annotations Reference

| Annotation | Purpose | Example Entity |
|------------|---------|----------------|
| `@Entity` | Marks a class as a JPA entity | All model classes |
| `@Id` | Defines primary key | All entities |
| `@GeneratedValue` | Auto-generates ID values | Maire, Commune |
| `@OneToOne` | One-to-one relationship | Maire � Commune |
| `@ManyToOne` | Many-to-one relationship | Commune � Departement |
| `@OneToMany` | One-to-many relationship | Departement � Communes |
| `@Embedded` | Embeds value object | Maire.adresse |
| `@Embeddable` | Marks class as embeddable | Adresse |
| `@ElementCollection` | Collection of basic types | Maire.emails |
| `@EmbeddedId` | Composite primary key | Classe |
| `@MappedSuperclass` | Inheritance base class | Utilisateur |
| `@NamedQuery` | Pre-defined query | Commune.byName |
| `@Enumerated` | Maps enum to DB | Civilite |

## Learning Objectives

By working through this project, you will learn:

1. **JPA Fundamentals**
   - Entity lifecycle (transient, managed, detached, removed)
   - Persistence context and EntityManager
   - Transaction management

2. **Relationship Mapping**
   - Unidirectional vs bidirectional relationships
   - Cascade types (PERSIST, REMOVE, ALL)
   - Fetch strategies (LAZY vs EAGER)
   - Join strategies and foreign keys

3. **Advanced Mapping**
   - Composite keys with `@EmbeddedId`
   - Embedded objects with `@Embedded`
   - Element collections
   - Inheritance strategies

4. **Querying**
   - JPQL (Java Persistence Query Language)
   - Native SQL queries
   - Named queries for reusability
   - Aggregate functions and joins
   - Bulk operations

5. **Best Practices**
   - Entity design patterns
   - Performance optimization
   - Transaction boundaries
   - Lazy loading pitfalls

## Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| **Java** | 17 | Programming language |
| **Maven** | 3.x | Build automation and dependency management |
| **JPA** | 3.x | Java Persistence API specification |
| **Hibernate** | 7.1.10.Final | JPA provider and ORM framework |
| **MySQL** | 8.0+ | Relational database management system |
| **MySQL Connector/J** | 9.5.0 | JDBC driver for MySQL |
| **JUnit Jupiter** | 5.11.0 | Unit testing framework |

## Authors

**Institution**: ENSIT (�cole Nationale Sup�rieure d'Informatique et des T�l�communications)

**Program**: Information Technology - Year 3

**Course**: Database Management and JPA

---

## Additional Resources

- [JPA Specification](https://jakarta.ee/specifications/persistence/)
- [Hibernate Documentation](https://hibernate.org/orm/documentation/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Java Records](https://docs.oracle.com/en/java/javase/17/language/records.html)

## License

This project is for educational purposes only.

---

**Happy Learning!** If you encounter any issues, please review the configuration settings and ensure your MySQL database is properly set up.