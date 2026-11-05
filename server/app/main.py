from datetime import datetime, timezone
from uuid import uuid4

from fastapi import FastAPI, HTTPException
from pydantic import BaseModel, Field

app = FastAPI(title="AI-Studio API", version="0.1.0")


class JobRequest(BaseModel):
    kind: str = Field(pattern="^(image|video)$")
    prompt: str = Field(min_length=1, max_length=4000)


jobs: dict[str, dict] = {}


@app.get("/health")
def health():
    return {"ok": True, "service": "ai-studio-api"}


@app.post("/v1/jobs", status_code=202)
def create_job(payload: JobRequest):
    job_id = str(uuid4())
    job = {
        "job_id": job_id,
        "kind": payload.kind,
        "prompt": payload.prompt,
        "status": "queued",
        "created_at": datetime.now(timezone.utc).isoformat(),
        "message": "Starter only: no generation engine is connected yet.",
    }
    jobs[job_id] = job
    return job


@app.get("/v1/jobs/{job_id}")
def get_job(job_id: str):
    if job_id not in jobs:
        raise HTTPException(status_code=404, detail="Job not found")
    return jobs[job_id]
