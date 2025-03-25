Run Demo

\# Feedback App Backend

Spring Boot backend service for a feedback management application.

\## Features

\- REST API for feedback operations

\- In-memory storage of feedback items

\- CORS configured for frontend access

\- Basic validation for feedback messages

\## Prerequisites

\- Java 17

\- Maven

\- (Optional) IDE like IntelliJ IDEA or Eclipse

\## Installation

\`\`\`bash

git clone \[your-repo-url\]

cd feedback-app-backend

mvn install

\## Running the App

mvn spring-boot:run





Run frontend

# Feedback App

A Vue.js application with Vuetify for managing user feedback.

## Features
- Submit feedback with message and optional author name
- View all feedback entries
- Mark feedback as helpful (with counter)
- Responsive design with Vuetify components
- Form validation

## Prerequisites
- Node.js (v18 or higher recommended)
- npm or yarn
- Backend server running at `http://localhost:8080`

## Installation
```bash
git clone [your-repo-url]
cd feedback-app
npm install

## Running the App
npm run dev
