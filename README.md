Vorlon
vorlon.
Invisible

Zach [DNET],  — 2:26 PM
@Greg  can you make a readme of how to setup everything
@Jonah  I need those changes you made on the email before
we presented
Jonah [HUNT],  — 2:30 PM
just comment out this method in emailservice and put a println in 

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
Zach [DNET],  — 2:31 PM
ok
I just dont want us to get a merge ocnlfict later
Jonah [HUNT],  — 2:31 PM
that was just on my laptop
Zach [DNET],  — 2:31 PM
oh
lmao
ok
i get you
Jonah [HUNT],  — 2:31 PM
im not using my laptop rn
 [DNET], 
Zach [DNET],  — 2:38 PM
ok, I finished htis, I also made it so they cannot select past dates on permit creation
I am going to add the not changing emails
Greg — 2:38 PM
I can get the readme file done, I'm downloading it and throwing it into ai if that's ok
to make it seem professional
Zach [DNET],  — 2:39 PM
make sure it actually works if you follow the steps
otherwise who cares
Greg — 2:40 PM
I don't have time to actually figure out if it actually works cause i got class in 20 minutes and don't have the database setup or anything but what I can do is post the readme file in here and I can make some changes after class to it
But it looks good to me, I don't see any problems just looking at it
let me send it noiw
# iPERMIT App — Group 14

A Spring Boot web application for managing environmental permit requests. Regulated Entities (REs) can register, submit permit requests, and pay fees online. Environmental Officers (EOs) can review applications, issue permits, and send notifications.

---

## Prerequisites

Make sure you have the following installed before getting started:

- **Java 17** (the project targets Java 17+)
- **Maven 3.6+** (or use the included `mvnw` wrapper)
- **PostgreSQL 13+**

---

## Database Setup

1. Open your PostgreSQL client (e.g., `psql` or pgAdmin).

2. Create the database:

```sql
CREATE DATABASE group14_ipermitdb;
```

3. Make sure a user named `postgres` exists with the password `password`. If you'd like to use different credentials, update `src/main/resources/application.properties` accordingly (see the Configuration section below).

The application uses `spring.jpa.hibernate.ddl-auto=update`, so Hibernate will automatically create and update all tables on first run. Seed data (two default permit types and a default EO account) is loaded from `src/main/resources/data.sql` on startup.

---

## Configuration

All application settings live in:

```
src/main/resources/application.properties
```

The key properties to review before running:

| Property | Default Value | Description |
|---|---|---|
| `spring.datasource.url` | `jdbc:postgresql://localhost:5432/group14_ipermitdb` | PostgreSQL connection URL |
| `spring.datasource.username` | `postgres` | Database username |
| `spring.datasource.password` | `password` | Database password |
| `spring.mail.username` | `environmentalministry158@gmail.com` | Gmail account used to send notifications |
| `spring.mail.password` | `Ipermit123` | Gmail app password |

> **Note:** The email credentials in `application.properties` are used by the EO notification system. If you want email sending to work in your own environment, replace these with your own Gmail account and an [App Password](https://support.google.com/accounts/answer/185833).

---

## Running the Application

### Option 1 — Using the Maven Wrapper (recommended)

From inside the `Group14_iPERMITAPP/` directory:

**macOS / Linux:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

### Option 2 — Using your system Maven

```bash
mvn spring-boot:run
```

### Option 3 — Build a JAR and run it

```bash
mvn clean package
java -jar target/Group14_iPERMITAPP-0.0.1-SNAPSHOT.jar
```

Once the application starts, open your browser and navigate to:

```
http://localhost:8080
```

---

## Default Accounts

Two types of users exist in the system:

### Environmental Officer (EO)
The EO account is seeded automatically by `data.sql`.

| Field | Value |
|---|---|
... (56 lines left)

README (1).md
6 KB
 [DNET], 
Zach [DNET],  — 2:47 PM
ok i added this,  but insted of emaiul I made it org name bc I tihnk that is what they said?
Greg — 2:48 PM
They said choose one, i don't think it matters just that one of them has to be a primary key so another account with the same info can't be created
Zach [DNET],  — 2:49 PM
ok i did email as well then bc that one already has behavior for disallowing the same email
what else needs to be done @Jonah
Jonah [HUNT],  — 2:53 PM
one sec
I have smth rn for the re dashboard thing but it has problems and chat gpt just told me I cant use anymore requests
current problem
Image
I might make a pr real quick and see if I cant have you finish this while I look over the readme and make a list of what still needs to be done
Zach [DNET],  — 2:57 PM
sounds good
what exactly id the issue i am fixing?
Jonah [HUNT],  — 2:58 PM
it has both a paid unpaid status and a approved/rejected/under review status and I only want one
Zach [DNET],  — 2:58 PM
got it
Jonah [HUNT],  — 2:59 PM
pr made
Zach [DNET],  — 2:59 PM
can you send the link
something is broken on githubs end
Jonah [HUNT],  — 3:00 PM
for the pr request?
Zach [DNET],  — 3:00 PM
yup
Jonah [HUNT],  — 3:00 PM
https://github.com/Quantam-Studios/Group14_iPERMITAPP/pull/12
GitHub
partially fixed Re dashboard issue by HeadlessCrusader · Pull Requ...
Zach [DNET],  — 3:00 PM
thanks
my refresh would not load it 
what are the possible rewquets states?
approved, rejected? anything else? pending?
Jonah [HUNT],  — 3:06 PM
Approved
 
Rejected
 
Payment Accepted
 
Being Reviewed
and if it doesn't have a status I belive its unpaid
i'm going to try and do some organization and commenting bc the readme looks good 
Zach [DNET],  — 3:08 PM
ok dont touch RE controller yet
Jonah [HUNT],  — 3:08 PM
and I think thats all we have left to do
lmk when I can
Zach [DNET],  — 3:15 PM
I feel like something is off with the statuses, bc it only shows as being reviewed if it is unpaid, but in our flow, if it is paid, it is under review
Image
so it will just say payment accepted
Jonah [HUNT],  — 3:15 PM
nice
Zach [DNET],  — 3:16 PM
you think its fine?
Jonah [HUNT],  — 3:16 PM
no I didn't see your first message
I think that may be a fragment of me having the part of the code that gave the being reviewed status commented out for certain reasons. it should be fixed in the version you have tho
Zach [DNET],  — 3:17 PM
odd...
when should it get the under review status?
Jonah [HUNT],  — 3:18 PM
oh wait its still commented out
its in RevieweSubmittedApplicationsForm
just remove the if statement around it
Zach [DNET],  — 3:20 PM
ok nice
Image
so should i invent a 5th status for unpaid
Jonah [HUNT],  — 3:21 PM
you can just check if there is no status
but you could if it would be easier
Zach [DNET],  — 3:22 PM
is the EO request view really supposed to only show the paid requests? I thought we had to have a report which showed every reuest
Jonah [HUNT],  — 3:22 PM
I was going off the workbook, but maybe
Zach [DNET],  — 3:22 PM
oh ok
Jonah [HUNT],  — 3:22 PM
you could do that just to be sure if you wanted to
 [DNET], 
Jonah [HUNT],  — 3:29 PM
oh I just noticed, I don't think unpaid requests should be able to have any review status other than awaiting payment
Zach [DNET],  — 3:29 PM
fixed it
Image
I also fixed the payment flow bc there was a bug
Jonah [HUNT],  — 3:30 PM
also I just noticed there is a status for unpaid which is 
Pending Payment
mf
Zach [DNET],  — 3:31 PM
I am going to add the RE Site to the permit app review page,  I just noticed it still doesnt happen mb
 [HUNT], 
Zach [DNET],  — 3:31 PM
should I adjust to fix this?
Jonah [HUNT],  — 3:31 PM
you can, but I just care that it works
also I moved stuff out of auth controller and home controller and deleted those files
Zach [DNET],  — 3:32 PM
why auth controller?
Jonah [HUNT],  — 3:32 PM
in registrationForm there where login methods, so it seems like that's where they were ment to go
Zach [DNET],  — 3:33 PM
ok, I know regfistrationform definitely has things that should not be put there
Jonah [HUNT],  — 3:34 PM
yea, I'm not worrying abt it too much, but I'm trying to move stuff to somewhere if I see unused methods that fit it
 [DNET], 
Zach [DNET],  — 3:35 PM
fixed this
Jonah [HUNT],  — 3:35 PM
cool
I'm getting chat gpt to comment the code
Zach [DNET],  — 3:35 PM
make sure you have up to date changes
I need to touch EO dashbaord stuff to add the report
Jonah [HUNT],  — 3:37 PM
do you want me to make a pr real quick?
Zach [DNET],  — 3:37 PM
yeah
Jonah [HUNT],  — 3:38 PM
actually I did a pull and it undid some of my changes, so just go ahead
which file should I not touch rn
 [HUNT], 
Jonah [HUNT],  — 3:38 PM
they shouldn't be too hard to redo
Zach [DNET],  — 3:39 PM
dashbaord html for eo, and I guess registrationform for now? since that seems to be the place for that stuff
Jonah [HUNT],  — 3:39 PM
ok
I'll redo the authcontroller and homecontroller stuff later
Imma comment stuff rn and maybe move some stuff in RE controller
Zach [DNET],  — 3:40 PM
ok
ok the report is in now
what else is there?
Jonah [HUNT],  — 3:45 PM
one moment
let me make a pr real fast, then update my branch, do smth and then it should just be commenting
Zach [DNET],  — 3:47 PM
did the readme look good?
Jonah [HUNT],  — 3:47 PM
looked good to me
but I would say give it the once over to make sure im not missing smth
created pr
﻿
# iPERMIT App — Group 14

A Spring Boot web application for managing environmental permit requests. Regulated Entities (REs) can register, submit permit requests, and pay fees online. Environmental Officers (EOs) can review applications, issue permits, and send notifications.

---

## Prerequisites

Make sure you have the following installed before getting started:

- **Java 17** (required — the project targets Java 17)
- **Maven 3.6+** (or use the included `mvnw` wrapper)
- **PostgreSQL 13+**

---

## Database Setup

1. Open your PostgreSQL client (e.g., `psql` or pgAdmin).

2. Create the database:

```sql
CREATE DATABASE group14_ipermitdb;
```

3. Make sure a user named `postgres` exists with the password `password`. If you'd like to use different credentials, update `src/main/resources/application.properties` accordingly (see the Configuration section below).

The application uses `spring.jpa.hibernate.ddl-auto=update`, so Hibernate will automatically create and update all tables on first run. Seed data (two default permit types and a default EO account) is loaded from `src/main/resources/data.sql` on startup.

---

## Configuration

All application settings live in:

```
src/main/resources/application.properties
```

The key properties to review before running:

| Property | Default Value | Description |
|---|---|---|
| `spring.datasource.url` | `jdbc:postgresql://localhost:5432/group14_ipermitdb` | PostgreSQL connection URL |
| `spring.datasource.username` | `postgres` | Database username |
| `spring.datasource.password` | `password` | Database password |
| `spring.mail.username` | `environmentalministry158@gmail.com` | Gmail account used to send notifications |
| `spring.mail.password` | `Ipermit123` | Gmail app password |

> **Note:** The email credentials in `application.properties` are used by the EO notification system. If you want email sending to work in your own environment, replace these with your own Gmail account and an [App Password](https://support.google.com/accounts/answer/185833).

---

## Running the Application

### Option 1 — Using the Maven Wrapper (recommended)

From inside the `Group14_iPERMITAPP/` directory:

**macOS / Linux:**
```bash
./mvnw spring-boot:run
```

**Windows:**
```cmd
mvnw.cmd spring-boot:run
```

### Option 2 — Using your system Maven

```bash
mvn spring-boot:run
```

### Option 3 — Build a JAR and run it

```bash
mvn clean package
java -jar target/Group14_iPERMITAPP-0.0.1-SNAPSHOT.jar
```

Once the application starts, open your browser and navigate to:

```
http://localhost:8080
```

---

## Default Accounts

Two types of users exist in the system:

### Environmental Officer (EO)
The EO account is seeded automatically by `data.sql`.

| Field | Value |
|---|---|
| Email | `environmentalministry158@gmail.com` |
| Password | `password` |

Log in with the EO credentials to access the EO dashboard, where you can review submitted permit applications and issue permits.

### Regulated Entity (RE)
REs self-register via the registration form on the login page. After registering, REs can log in to submit permit requests, track application status, and pay fees.

---

## Project Structure

```
Group14_iPERMITAPP/
├── src/main/java/edu/mizzou/Group14_iPERMITAPP/
│   ├── controller/        # MVC controllers (auth, RE, EO flows)
│   ├── model/             # JPA entity classes
│   ├── repository/        # Spring Data JPA repositories
│   └── service/           # Business logic (registration, payments, emails, etc.)
├── src/main/resources/
│   ├── application.properties   # App & DB configuration
│   ├── data.sql                 # Seed data (permits + default EO)
│   └── templates/               # Thymeleaf HTML templates
└── pom.xml
```

---

## Key Dependencies

- **Spring Boot 4.0.5** — application framework
- **Spring Data JPA + Hibernate** — ORM / database access
- **PostgreSQL Driver** — JDBC driver for PostgreSQL
- **Thymeleaf** — server-side HTML templating
- **Spring Boot Mail (Jakarta Mail)** — email notifications via Gmail SMTP
- **Lombok** — reduces boilerplate (getters, setters, constructors)

---

## Troubleshooting

**`Connection refused` on startup**
Ensure PostgreSQL is running and listening on port 5432. Verify the database `group14_ipermitdb` exists and that the credentials in `application.properties` match your local setup.

**`Password authentication failed for user "postgres"`**
Either update the `spring.datasource.password` in `application.properties` to match your actual Postgres password, or reset the `postgres` user's password in psql:
```sql
ALTER USER postgres WITH PASSWORD 'password';
```

**Tables not created automatically**
Confirm `spring.jpa.hibernate.ddl-auto=update` is set in `application.properties`. On a brand-new database, Hibernate will generate all tables on the first run.

**Email notifications not sending**
Gmail requires an [App Password](https://support.google.com/accounts/answer/185833) (not your regular Gmail password) when 2-Step Verification is enabled. Update `spring.mail.username` and `spring.mail.password` in `application.properties` with your own credentials.
README (1).md
6 KB