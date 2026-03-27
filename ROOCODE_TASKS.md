# RooCode Task Breakdown (derived from CLAUDE.md)

Purpose: make the CLAUDE.md directives executable as RooCode tasks so future runs avoid re-reading.

## 0) Ground rules (must honor while executing any task)
- Enforce BA-first: no assumptions without BA validation; document each clarification.
- Hourly updates to PM using the structured format from CLAUDE.md (agent, to, time, task, status, blockers, next).
- Synthetic data fallback is mandatory; never block on real data.
- Keep modules decoupled (Flutter, Spring Boot, Rust ML, RAG, DB).
- Explainability required for eligibility outputs (reasons list).

## 1) Governance & communication setup
- Define agent roles (PM, BA, Rust Dev 1/2, Flutter Dev 1/2, Spring Boot Dev) and their responsibilities per CLAUDE.md.
- Produce a comms protocol doc: message format, hourly report template, escalation path.
- Output: `docs/comms_protocol.md` capturing templates and cadence.

## 2) Policy data collection & normalization (BA-led)
- Gather PMAY sources (pmayg.nic.in AwaasSoft, data.gov.in, ministry portals, indiacode). If inaccessible, generate synthetic policy text.
- Extract eligibility rules, benefits, target categories into normalized JSON.
- Output: `data/policy/pmay_policy.json` with versioning notes and provenance.

## 3) Citizen schema + synthetic dataset (BA-led)
- Define schema: citizen_id, income (0–10L), house_type (kutcha/semi-pucca/pucca), family_size, category (SC/ST/OBC/General), district.
- Generate synthetic dataset aligned to PMAY distributions and validate ranges/categories.
- Output: `data/citizens/synthetic_citizens.json` + `data/citizens/VALIDATION.md` listing checks.

## 4) Spring Boot backend foundation
- Scaffold API gateway with endpoints:
  - POST `/citizen/register`
  - GET `/citizen/{id}`
  - POST `/eligibility/check`
  - GET `/schemes/recommend`
- Include DTOs/models, validation, and stub integrations to Rust services.
- Output: Spring Boot module with controller, service, and integration client stubs; minimal tests.

## 5) Rust ML eligibility engine (Phase 1 rules, Phase 2 ML-ready)
- Implement rule-based scoring driven by JSON policy; return eligible flag, score (0–1), and reasons array.
- Design interfaces to swap in gradient boosting (e.g., XGBoost bindings) without breaking API.
- Output: Rust service crate exposing REST/gRPC endpoint `/score`; config for policy/rules.

## 6) RAG pipeline
- Build ingestion: load policy docs (PDF/HTML/text), chunk, embed, and store in vector DB (FAISS/Qdrant).
- Query flow: embed query → retrieve → respond with matching policy clauses.
- Output: RAG service with ingestion script, retrieval endpoint, and sample run logs.

## 7) Flutter app (Citizen + Field Officer)
- Screens: Login, Eligibility result (score + “why”), Application form, Dashboard.
- Wire to backend APIs; add basic error handling and loading states.
- Output: Flutter app module with API client, state management, and the four screens.

## 8) Integration (Spring Boot ↔ Rust services)
- Connect Spring Boot to Rust ML and RAG via REST/gRPC; handle timeouts, retries, and error mapping.
- Provide environment config for service URLs/ports.
- Output: integration clients, configuration samples, and an end-to-end smoke test script.

## 9) Production hardening
- Add JWT auth, rate limiting, structured logging; caching for ML/RAG responses where applicable.
- Improve explainability output and basic offline handling in Flutter; UI polish.
- Output: security middleware/configs, cache layer, updated UI flows.

## 10) Compliance & QA checklist
- Verify adherence to non-negotiables: BA validation logged, synthetic data fallback used, hourly updates recorded, explainability present, modules decoupled.
- Output: `docs/compliance_checklist.md` with pass/fail per item and links to evidence.

## 11) Delivery artifacts
- PRs per module (backend, Rust, Flutter, data) with test notes.
- Demo script describing end-to-end flow from citizen input to eligibility/recommendation response.

Execution note: Each task should be run in multi-agent mode per CLAUDE.md, with BA gating assumptions and PM receiving hourly status reports.
