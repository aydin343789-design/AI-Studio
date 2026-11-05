# AI-Studio API

This is a starter API only. It currently queues placeholder jobs in memory and does not generate images or videos.

Run locally:
```bash
pip install -r requirements.txt
uvicorn app.main:app --reload
``

Endpoints:
- GET /health
- POST /v1/jobs
- GET /v1/jobs/{job_id}

Do not expose this starter endpoint publicly without authentication, rate limits, durable queueing, and job ownership checks.
