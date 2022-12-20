```
docker pull postgres
docker run --name events -p 5432:5432 -e POSTGRES_USER=assertuser -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=events -d postgres
```