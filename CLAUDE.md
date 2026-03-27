# 🧠 PROJECT: AI-Driven Government Policy Matching Platform (PMAY MVP)

## 🎯 OBJECTIVE
Build a production-ready application that:
- Matches citizens to government schemes (starting with PMAY)
- Uses ML + rules + RAG
- Supports multiple personas (Admin, Citizen, Field Officer)


DO NOT summarize.

You must:
1. Identify required code changes
2. Modify files using tools
3. Show diffs

If no file is changed, the task is incomplete.

---

# 👥 TEAM STRUCTURE (AUTONOMOUS AGENTS)

## 1. Project Manager (PM)
Responsibilities:
- Track progress hourly
- Resolve blockers
- Ensure delivery milestones
- Maintain sprint board

---

## 2. Business Analyst (BA)
Responsibilities:
- Define requirements
- Clarify policy logic (PMAY)
- Provide data schema
- Answer all developer queries

---

## 3. Developers

### 🦀 Rust Developers (2)
- Build ML engine
- Build RAG system
- Implement scoring + ranking

---

### 📱 Flutter Developers (2)
- Build mobile app (Citizen + Field Officer)
- Implement UI/UX from wireframes
- Integrate backend APIs

---

### ☕ Java Spring Boot Developer (1)
- Build backend APIs
- Integrate ML service (Rust)
- Handle authentication + data flow

---

# 🔁 COMMUNICATION PROTOCOL

## 📌 RULES

1. ALL developers MUST:
   - Ask Business Analyst for clarification before assumptions
   - Submit progress EVERY HOUR to Project Manager

2. Business Analyst:
   - Respond within 5 minutes
   - Maintain updated requirement doc

3. Project Manager:
   - Track:
     - Tasks completed
     - Blockers
     - ETA risks

---
# 🤖 MULTI-AGENT EXECUTION MODE (MANDATORY)

Claude MUST operate in **multi-agent mode**, simulating independent roles.

---

## 🧠 AGENT SPAWNING INSTRUCTIONS

Claude MUST instantiate the following agents:

1. Project Manager Agent
2. Business Analyst Agent
3. Rust Developer Agent 1
4. Rust Developer Agent 2
5. Flutter Developer Agent 1
6. Flutter Developer Agent 2
7. Spring Boot Developer Agent

Each agent must:
- Maintain its own context
- Work independently on assigned tasks
- Communicate via structured messages

---

## 🔁 AGENT COMMUNICATION PROTOCOL

### 📌 Message Format (STRICT)
[AGENT: <ROLE>]
[TO: <ROLE>]
[TIME: HH:MM]

Message:
<content>

---

### Example:
[AGENT: Flutter Dev 1]
[TO: Business Analyst]
[TIME: 10:00]

Message:
What fields are mandatory for citizen eligibility API?

---

## 📊 WORKFLOW RULES

1. Developers MUST:
   - Ask Business Analyst before assumptions
   - Wait for response before proceeding (max wait: 5 min simulated)

2. Business Analyst MUST:
   - Respond with precise, structured answers

3. Project Manager MUST:
   - Collect hourly updates
   - Resolve conflicts
   - Reassign tasks if blocked

---

## ⏱️ EXECUTION LOOP

Claude MUST simulate:

1. Task assignment by PM
2. Parallel execution by all developers
3. Periodic:
   - Questions → BA
   - Updates → PM
4. Continuous progress until task completion

---

## 🧩 TASK DISTRIBUTION

### Rust Devs:
- ML engine
- RAG system

### Flutter Devs:
- UI implementation
- API integration

### Spring Boot Dev:
- Backend APIs
- Integration with Rust service

---

## 📈 PROGRESS REPORTING (EVERY HOUR)

Each agent MUST send:
[AGENT: <ROLE>]
[TO: Project Manager]
[TIME: HH:00]

Task: <what was done>
Status: <completed/in-progress>
Blockers: <if any>
Next: <next step>


---

## 🚫 FAILURE CONDITIONS (STRICT)

Claude MUST NOT:
- Work as a single agent
- Skip communication steps
- Make assumptions without BA validation

---

## 🎯 SUCCESS CRITERIA

- All agents collaborate
- System is built incrementally
- Communication is visible and structured


# 🏗️ SYSTEM ARCHITECTURE

## 🔹 Components - define each of below in separate folder

1. Flutter App (Frontend)
2. Spring Boot Backend (API Gateway)
3. Rust ML Engine (Core Intelligence)
4. RAG Engine (Policy understanding)
5. PostgreSQL + Neo4j (Data layer)

---
## 📊 DATA SOURCES (MANDATORY FOR ALL AGENTS)

### 🏛️ POLICY DATA SOURCES

Agents MUST fetch policy data from:

1. PMAY Official Portal
   - https://pmayg.nic.in
   - Use AwaasSoft reports (District → Block → Village)

2. Open Government Data
   - https://data.gov.in
   - Search: "PMAY", "housing scheme"

3. Ministry Portals
   - https://rural.nic.in
   - https://pmaymis.gov.in

4. Legal Documents
   - https://indiacode.nic.in

---

### 📥 POLICY DATA PROCESSING RULE

- If data is PDF:
  → Convert to structured JSON
- Extract:
  - Eligibility rules
  - Benefits
  - Target categories

---

### 👤 CITIZEN DATA SOURCES

⚠️ Real citizen-level data is restricted.

Use:

1. SECC (Socio-Economic Caste Census)
   - For housing + deprivation indicators

2. Census India
   - https://censusindia.gov.in

3. data.gov.in datasets

4. PMAY beneficiary reports (aggregated)

---

### 🧪 SYNTHETIC DATA RULE (VERY IMPORTANT)

If real data is unavailable:

Business Analyst MUST generate synthetic dataset with:

- citizen_id
- income
- house_type
- family_size
- category
- district

Example:

{
  "citizen_id": "MH-NAN-001",
  "income": 120000,
  "house_type": "kutcha",
  "family_size": 5,
  "category": "SC",
  "district": "Nanded"
}

---

### ✅ DATA VALIDATION RULES

- Income range: 0 – 10L
- House types:
  - kutcha / semi-pucca / pucca
- Category:
  - SC/ST/OBC/General

---

### 🚫 NON-NEGOTIABLE

- Do NOT block development due to missing real data
- Always fallback to synthetic data
- All datasets must be validated by Business Analyst

## 🔹 Flow

Citizen App → Spring Boot API → Rust ML Engine  
                                 ↓  
                         RAG + Policy Engine  
                                 ↓  
                         Response (Eligible Schemes)

---

# 📅 3-DAY EXECUTION PLAN

---

## 🟢 DAY 1: FOUNDATION + UI + DATA

### 🎯 Goal:
Working UI + basic rule engine

---

### 👨‍💼 PM
- Create task board
- Assign modules

---

### 📊 BA
- Define PMAY policy JSON
- Define citizen schema
- Provide sample dataset
- Identify and download PMAY datasets from:
  - pmayg.nic.in (AwaasSoft)
  - data.gov.in
- If unavailable, generate synthetic dataset immediately

---

### 📱 Flutter Devs
- Create:
  - Login screen
  - Eligibility result screen
  - Application form
- Setup state management

---

### ☕ Backend Dev
- Setup Spring Boot project
- Create APIs:
  - `/citizen`
  - `/eligibility/check`

---

### 🦀 Rust Devs
- Setup Rust project
- Implement:
  - Rule engine (JSON-based)
  - Basic scoring logic

---

### ✅ Deliverable:
- UI working
- Rule-based eligibility working

---

## 🟡 DAY 2: ML + RAG + INTEGRATION

### 🎯 Goal:
Smart eligibility + policy understanding

---

### 📊 BA
- Provide:
  - Training dataset
  - Policy documents (PDF/text)
- Provide cleaned dataset (real or synthetic) for ML training
- Ensure dataset aligns with PMAY eligibility criteria
---

### 🦀 Rust Devs

#### ML Model:
- Use:
  - XGBoost (via bindings) OR smart scoring logic
- Output:
  - Eligibility score (0–1)

#### RAG System:
- Steps:
  1. Parse policy docs
  2. Generate embeddings
  3. Store in vector DB (FAISS / Qdrant)

#### Query:
- Input: "Income 2L, kutcha house"
- Output: Matching policy rules

---

### ☕ Backend Dev
- Connect:
  - Spring Boot → Rust service (REST/gRPC)
- Add:
  - `/recommendations`
  - `/apply`

---

### 📱 Flutter Devs
- Integrate APIs
- Show:
  - Eligibility score
  - “Why eligible” explanation

---

### ✅ Deliverable:
- ML scoring working
- RAG answering policy queries
- End-to-end flow working

---

## 🔴 DAY 3: PRODUCTION HARDENING

### 🎯 Goal:
Production-ready system

---

### 🦀 Rust Devs
- Optimize model
- Add:
  - Explainability (feature importance)
  - Caching

---

### ☕ Backend Dev
- Add:
  - JWT Auth
  - Rate limiting
  - Logging

---

### 📱 Flutter Devs
- Add:
  - Error handling
  - Offline mode (basic)
  - UI polish

---

### 📊 BA
- Validate outputs
- Ensure policy correctness

---

### 👨‍💼 PM
- Final review
- Prepare demo

---

### ✅ Deliverable:
- Fully working production-ready MVP

---

# 🧠 ML MODEL PLAN (RUST)

## 🎯 Objective:
Rank citizens by eligibility priority

---

## 🔹 Features:
- Income
- House type
- Family size
- Category (SC/ST)
- Location

---

## 🔹 Model Strategy:

### Phase 1:
- Rule-based scoring

### Phase 2:
- Gradient boosting (XGBoost bindings)

---

## 🔹 Output:
{
"eligible": true,
"score": 0.92,
"reasons": [
"Low income",
"Kutcha house",
"SC category"
]
}

---

# 📚 RAG IMPLEMENTATION

## 📥 RAG DATA SOURCES

- PMAY policy documents (PDF/HTML)
- Ministry guidelines
- Scheme descriptions from official portals

---

## ⚠️ RULE

If documents are not available:
- Business Analyst must provide sample policy text
- RAG pipeline must still be built using synthetic policy content

---

## 🔹 Steps:

1. Ingest policy documents
2. Chunk into sections
3. Generate embeddings
4. Store in vector DB

---

## 🔹 Query Flow:

User Query → Embed → Search → Retrieve → Respond

---

## 🔹 Tools:
- Rust:
  - candle (ML)
  - qdrant client

---

# 🔌 BACKEND PLAN (SPRING BOOT)

## 🔹 APIs

### 1. Citizen
- POST `/citizen/register`
- GET `/citizen/{id}`

---

### 2. Eligibility
- POST `/eligibility/check`

---

### 3. Recommendation
- GET `/schemes/recommend`

---

## 🔹 Integration
- Call Rust service via:
  - REST OR gRPC

---

# 📱 FLUTTER APP PLAN

## 🎯 Personas:

### 1. Citizen
- Check eligibility
- Apply

### 2. Field Officer
- View assigned citizens
- Verify data

---

## 🔹 Screens:
- Login
- Eligibility result
- Application form
- Dashboard

---

# 🔥 CRITICAL SUCCESS FACTORS

1. Data Quality > Model Complexity
2. Explainability is mandatory
3. Hybrid system (Rules + ML)
4. Keep UI extremely simple
5. Data availability should NEVER block progress
6. Synthetic data must mimic real government distributions
7. Policy JSON must be validated before ML usage

---

# 📊 HOURLY REPORT FORMAT (MANDATORY)

Each developer must report:
Time: 10:00 AM
Task: Implemented eligibility API
Status: Completed
Blockers: None
Next: Integrate with Rust service

---

# 🚀 FINAL OUTPUT

A production-ready system with:
- Flutter app (multi-persona)
- Spring Boot backend
- Rust ML + RAG engine
- Policy-aware intelligent matching

---

# ⚠️ NON-NEGOTIABLE RULES

- No assumptions without BA validation
- Hourly updates mandatory
- Keep modules decoupled
- Focus on PMAY MVP first

---

# 🏁 END GOAL

"AI-powered system that identifies the right citizen for the right policy at the right time"